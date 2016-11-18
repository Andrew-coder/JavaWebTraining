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

import java.util.Arrays;

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
    public void testSortToys() {
        Toy[] toys = {new Toy(30,ToyType.CUBE), new Toy(40,ToyType.BALL),
                new Toy(25,ToyType.CAR), new Toy(35,ToyType.BALL)};
        testModel.setToys(Arrays.asList(toys));
        GameRoom room = new GameRoom();
        room.setAllocatedCosts(300);
        room.addToy(new Toy(40,ToyType.BALL));
        room.addToy(new Toy(30,ToyType.CUBE));
        room.addToy(new Toy(35,ToyType.BALL));
        room.addToy(new Toy(25,ToyType.CAR));
        testModel.sortToys(SortMethod.BY_TOYS_PRICE);
        room.sortToys(SortMethod.BY_TOYS_PRICE);
        for(int i=0;i<testModel.getToys().size();++i) {
            Assert.assertEquals(testModel.getToys().get(i),room.getToys().get(i));
        }
    }

    @Test
    public void testCalculateTotalToysPrice(){
        testModel.addToy(new Toy(52, ToyType.CAR));
        testModel.addToy(new Toy(63, ToyType.BALL));
        Assert.assertEquals(testModel.calculateTotalToysPrice(),115);
    }
}
