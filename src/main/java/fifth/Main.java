package fifth;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import scala.Tuple2;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Main {

    public static void main(String[] args) throws Exception {

        if (args.length != 3)
            throw new IllegalArgumentException("Input parameters has to contain input, output and master node info");

        String input = args[0];
        String output = args[1];
        String node = args[2];

        SparkConf sparkConf = new SparkConf().setAppName("Friends").setMaster(node);
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        List<Tuple2<Friends, Integer>> sparkResult = sc.textFile(input)
                .flatMapToPair(new PairFlatMapFunction<String, Integer, Integer>() {
                    @Override
                    public Iterable<Tuple2<Integer, Integer>> call(String line) throws Exception {
                        Person person = ColumnHelper.parseLine(line);

                        if (person == null) return Collections.emptyList();

                        List<Tuple2<Integer, Integer>> result = new ArrayList<>();

                        Integer ownerId = person.getOwnerId();

                        for (Integer friendId : person.getFriends()) {
                            result.add(new Tuple2<>(friendId, ownerId));
                        }

                        return result;
                    }
                })
                .groupByKey()
                .flatMapToPair(new PairFlatMapFunction<Tuple2<Integer,Iterable<Integer>>, Friends, Integer>() {
                    @Override
                    public Iterable<Tuple2<Friends, Integer>> call(Tuple2<Integer, Iterable<Integer>> integerIterableTuple2) throws Exception {
                        List<Tuple2<Friends, Integer>> result = new ArrayList<>();

                        List<Friends> friendPairs = FriendsCollector.collect(integerIterableTuple2._2);

                        for (Friends friends : friendPairs) {
                            result.add(new Tuple2<>(friends, 1));

                        }

                        return result;
                    }
                })
                .reduceByKey(new Function2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer v1, Integer v2) throws Exception {
                        return v1 + v2;
                    }
                })
                .takeOrdered(10, new FriendsComparator());

        ArrayList<String> result = new ArrayList<>();

        for (Tuple2<Friends, Integer> tuple : sparkResult) {
            result.add("Friends pair " + tuple._1 + " having " + tuple._2 + " common friends");
        }

        Files.write(Paths.get(output), result, StandardCharsets.UTF_8);

        sc.stop();
    }


}