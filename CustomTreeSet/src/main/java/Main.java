import java.util.TreeSet;

/**
 * Created by andri on 11/27/2016.
 */
public class Main {
    public static void main(String[] args) {
        CustomTreeSet<Integer> set = new CustomTreeSet<>();
        set.add(60);
        set.add(40);
        set.add(30);
        set.add(90);
        set.add(80);
        set.add(20);
        set.add(10);
        set.add(50);
        set.add(2);
        set.remove(new Integer(2));
    }
}
