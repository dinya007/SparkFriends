package fifth;

import scala.Tuple2;

import java.io.Serializable;
import java.util.Comparator;

public class FriendsComparator implements Comparator<Tuple2<Friends, Integer>>, Serializable {

    @Override
    public int compare(Tuple2<Friends, Integer> o1, Tuple2<Friends, Integer> o2) {
        return o2._2.compareTo(o1._2);
    }
}
