package fifth;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FriendsTest {

    private final Friends friends1 = new Friends(1, 2);
    private final Friends friends2 = new Friends(2, 1);
    private final Friends friends3 = new Friends(2, 3);

    @Test
    public void equalsTest() throws Exception {
        Assert.assertTrue(friends1.equals(friends1));
        Assert.assertTrue(friends1.equals(friends2));
        Assert.assertTrue(friends2.equals(friends2));
        Assert.assertTrue(friends2.equals(friends1));
        Assert.assertFalse(friends1.equals(friends3));
        Assert.assertFalse(friends3.equals(friends2));
    }

    @Test
    public void hashCodeTest() throws Exception {
        Assert.assertEquals(friends1.hashCode(), friends2.hashCode());
    }

}