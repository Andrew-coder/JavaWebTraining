package Iterator;

/**
 * Created by andri on 11/15/2016.
 */
public interface Aggregate {
    Iterator getIterator();
}

public interface Iterator {
    boolean hasNext();
    Object next();
}

public class ConcreteAggregate implements Aggregate {
    int mas[] = {5,2,4,1,3};
    @Override
    public Iterator getIterator() {
        return new CocreteIterator();
    }

    private class CocreteIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index<mas.length?true:false;
        }

        @Override
        public Object next() {
            return mas[index++];
        }
    }
}

class Main {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        Iterator iterator = aggregate.getIterator();
        while(iterator.hasNext()) {
            System.out.println((String)iterator.next());
        }
    }
}