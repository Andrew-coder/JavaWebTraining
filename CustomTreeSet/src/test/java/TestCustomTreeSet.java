import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by andri on 11/27/2016.
 */
public class TestCustomTreeSet {
    public static final int ITERATIONS = 1000;
    CustomTreeSet treeSet;

    @Before
    public void initialize(){
        treeSet = new CustomTreeSet();
    }

    @Test
    public void testSize(){
        for(int i=0; i<ITERATIONS;++i){
            treeSet.add(i);
        }
        assertEquals(ITERATIONS,treeSet.size());
    }

    @Test
    public void testContains(){
        for(int i=0; i<ITERATIONS;++i){
            treeSet.add(i);
        }
        for(int i=0; i<ITERATIONS; ++i)
            assertTrue(treeSet.contains(i));
    }

    @Ignore
    @Test
    public void testAdd(){

    }
}
