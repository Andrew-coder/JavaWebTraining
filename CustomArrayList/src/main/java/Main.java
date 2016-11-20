import collection.CustomArrayList;

import java.util.ListIterator;

/**
 * Created by andri on 10/21/2016.
 */
public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(0);
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
