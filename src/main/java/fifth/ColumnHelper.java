package fifth;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColumnHelper {

    private static final Pattern pattern = Pattern.compile("(\\d+)\\s+\\{(.*)\\}");
    private static final Pattern pattern2 = Pattern.compile("\\(([^)]*)\\)");

    private ColumnHelper() {

    }

    public static Person parseLine(String line) {

        Matcher matcher = pattern.matcher(line);

        if (matcher.matches()) {
            Integer owner = Integer.valueOf(matcher.group(1));

            String friendsGroup = matcher.group(2);

            Matcher matcher2 = pattern2.matcher(friendsGroup);

            List<Integer> friends = new ArrayList<>();
            while (matcher2.find()) {
                friends.add(Integer.valueOf(matcher2.group(1).split(",")[0]));
            }

            return new Person(owner, friends);
        } else {
            return null;
        }
    }


}