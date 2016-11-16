package Strategy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by andri on 11/16/2016.
 */
public interface Sorting {
    void sort(int[] array);
}

public class BubbleSort implements Sorting {
    @Override
    public void sort(int[] array) {
        System.out.println("bubble sorting");
        System.out.println("before: "+Arrays.toString(array));
        for(int i=array.length-1;i>=0;--i) {
            for(int j= 0;j<i;++j) {
                if(array[i]<array[j]) {
                    int tmp = array[i];
                    array[j]=tmp;
                }
                array[i]=array[j];
            }
        }
        System.out.println("after: "+Arrays.toString(array));
    }
}

public class SelectionSort implements Sorting {
    @Override
    public void sort(int[] array) {
        System.out.println("selection sorting");
        System.out.println("before: "+Arrays.toString(array));
        for(int i=0;i<array.length-1;++i) {
            for(int j= i+1;j<array.length;++j) {
                if(array[j]<array[i]) {
                    int tmp = array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
        System.out.println("after: "+Arrays.toString(array));
    }
}

public class StrategyClient {
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] array) {
        strategy.sort(array);
    }
}

class Main {
    public static void main(String[] args) {
        StrategyClient client = new StrategyClient();
        int[] array = {5,2,4,1,3};
        client.setStrategy(new BubbleSort());
        client.executeStrategy(array);

        client.setStrategy(new SelectionSort());
        client.executeStrategy(array);
    }
}
