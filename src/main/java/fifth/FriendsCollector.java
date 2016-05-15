package fifth;

import java.util.ArrayList;
import java.util.List;

public class FriendsCollector {

    private FriendsCollector() {

    }

    public static List<Friends> collect(Iterable<Integer> friendIds) {

        List<Integer> idList = convertIterToList(friendIds);

        List<Friends> result = new ArrayList<>();
        for (int i = 0; i < idList.size() - 1; i++) {
            for (int j = i + 1; j < idList.size(); j++) {
                result.add(new Friends(idList.get(i), idList.get(j)));
            }
        }

        return result;
    }

    private static List<Integer> convertIterToList(Iterable<Integer> iterable) {
        List<Integer> result = new ArrayList<>();
        for (Integer id : iterable) {
            result.add(id);
        }
        return result;
    }
}
