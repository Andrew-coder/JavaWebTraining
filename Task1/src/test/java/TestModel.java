import model.Model;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by andri on 10/30/2016.
 */

public class TestModel {
    private Model testModel;

    /**
     * method where initialize the instance of testModel
     */
    @Before
    public void initialize() {
        testModel = new Model();
    }

    /**
     * test method where checks is number in specified range or not
     */
    @Test
    public void testRandWithBorders() {
        int randNumber = testModel.rand(1,10);
        Assert.assertTrue(randNumber>=1 && randNumber<=10);
    }

    /**
     * test method where checks is number in default range or not
     */
    @Test
    public void testDefaultRand() {
        int randNumber = testModel.rand();
        Assert.assertTrue(randNumber>=Model.RAND_MIN && randNumber<=Model.RAND_MAX);
    }

    /**
     * test method which check the work of check method
     */
    @Test
    public void testCheckNumber() {
        testModel.setGuessValue(35);
        Assert.assertTrue(testModel.checkNumber(35));
    }
}
