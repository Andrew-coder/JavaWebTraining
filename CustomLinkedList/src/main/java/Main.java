import java.util.List;
import java.util.ListIterator;

/**
 * Created by andri on 11/24/2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new CustomLinkedList<>();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(0);
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
