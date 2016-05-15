package fifth;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ColumnHelperTest {

    private String line = "1136\t{(4913,0),(17772,0),(674295,0),(1207604,0),(1323442,0),(1325381,0),(1330326,0),(1334620,0),(1901141,0),(2281531,0),(2609000,0),(2704958,0),(3306478,0),(3307499,0),(3337785,32),(4033797,0),(4609605,0),(4611451,0),(4612933,512),(4811461,0),(5349992,0),(5386586,0),(5932303,0),(5996541,0),(6253722,256),(6583452,0),(6589460,0),(7249963,1024),(7252160,0),(7253365,1024),(7312782,1),(7891795,0),(8510522,0),(8561714,0),(8630111,0),(8744431,0),(9230626,1024),(9930414,0)}";

    @Test
    public void parseLine() throws Exception {
        Person result = ColumnHelper.parseLine(line);

        List<Integer> friends = result.getFriends();

        Assert.assertEquals(new Integer(1136), result.getOwnerId());
        Assert.assertNotNull(friends);
        Assert.assertTrue(friends.contains(4913) && friends.contains(2704958));
    }

}