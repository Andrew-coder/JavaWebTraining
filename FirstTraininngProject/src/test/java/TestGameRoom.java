/**
 * Created by andri on 11/17/2016.
 */
import model.entity.GameRoom;
import model.entity.SortMethod;
import model.entity.Toy;
import model.entity.ToyType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestGameRoom {
    private GameRoom testModel;

    @Before
    public void initialize(){
        testModel = new GameRoom();
        testModel.setAllocatedCosts(300);
    }

    @Test(expected = RuntimeException.class)
    public void testAddToy(){
        testModel.addToy(new Toy(301, ToyType.BALL));
    }

    @Test
    @Ignore
    public void testSortToys() {

    }

    @Test
    public void testCalculateTotalToysPrice(){
        testModel.addToy(new Toy(52, ToyType.CAR));
        testModel.addToy(new Toy(63, ToyType.BALL));
        Assert.assertEquals(testModel.calculateTotalToysPrice(),115);
    }
}
