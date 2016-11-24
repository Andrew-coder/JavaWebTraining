package test;

import collection.CustomArrayList;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by andri on 11/24/2016.
 */
public class TestCustomArrayList {
    List<Integer> list;

    @Before
    public void init(){
        list = new CustomArrayList<>();
    }

    @Test
    public void testSize(){
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3,list.size());
    }

    @Test
    public void testIsEmty(){
        assertEquals(0,list.size());
    }

    @Test
    public void testContains(){
        list.add(10);
        list.add(20);
        list.add(30);
        assertTrue(list.contains(20));
    }

    @Test
    public void testRemove(){
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(new Integer(20));
        List<Integer> list2 = new CustomArrayList<>();
        list2.add(10);
        list2.add(30);
        assertTrue(list2.equals(list));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet(){
        list.add(10);
        list.add(20);
        list.add(30);
        list.get(10);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIterator(){
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        ListIterator<Integer> iterator = list.listIterator();
        int i=0;
        while(iterator.hasNext()){
            if(i==list.size()/2){
                list.clear();
            }
            iterator.next();
            ++i;
        }
    }
}
