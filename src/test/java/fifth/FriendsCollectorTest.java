package fifth;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FriendsCollectorTest {
    @Test
    public void collect() throws Exception {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Friends> result = FriendsCollector.collect(integers);

        System.out.println(result);
        Assert.assertEquals(3, result.size());
    }

}