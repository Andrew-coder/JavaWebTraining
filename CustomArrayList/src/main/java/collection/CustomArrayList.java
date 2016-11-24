package collection;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Created by andri on 11/20/2016.
 */
public class CustomArrayList<E> implements List<E> {
    private static final int INITIAL_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private Object elementData[]={};
    private int size = 0;
    private int modCount = 0;
    public CustomArrayList() {
        elementData = new Object[INITIAL_CAPACITY];
    }

    public void ensureCapacity(int capacity) {
        modCount++;
        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                ? 0
                : INITIAL_CAPACITY;
        if (capacity > minExpand) {
            int newArrayLength = (elementData.length * 3) / 2 + 1;
            if (newArrayLength < capacity) {
                newArrayLength = capacity;
            }
            Object newArray[] = new Object[newArrayLength];
            System.arraycopy(elementData, 0, newArray, 0, size);
            elementData = newArray;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override
    public Object[] toArray() {
        return (E[])Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size+1);
        elementData[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        modCount++;

        // clear to let GC do its work
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);

        return (E)elementData(index);
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("out of boundary: "+index);
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    private void selfArrayCopy(int from, int to, int quantity) {
        if (from > to) {
            System.arraycopy(elementData, from, elementData, to, quantity);
        } else if (from < to) {
            Object newArray[] = new Object[elementData.length];
            System.arraycopy(elementData, 0, newArray, 0, from + 1);
            System.arraycopy(elementData, from, newArray, to, quantity);
            elementData = newArray;
        }
    }

    @Override
    public void add(int index, E element) {
        ensureCapacity(size + 1);
        selfArrayCopy(index, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new CustomListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: "+index);
        return new CustomArrayList.CustomListIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {return null;}

    @Override
    public void replaceAll(UnaryOperator<E> operator) {}

    @Override
    public void sort(Comparator<? super E> c) {}

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    private class CustomListIterator extends CustomIterator implements ListIterator<E> {

        public CustomListIterator(int currentIndex) {

            this.current = currentIndex;
        }

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public E previous() {
            checkForComodification();
            int i = current - 1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] elementData = CustomArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            current = i;
            return (E) elementData[lastReturned = i];
        }

        @Override
        public int nextIndex() {
            return current;
        }

        @Override
        public int previousIndex() {
            return current-1;
        }

        @Override
        public void set(E e) {
            if (lastReturned < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                CustomArrayList.this.set(lastReturned, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void add(E e) {
            checkForComodification();
            try {
                int i = current;
                CustomArrayList.this.add(i, e);
                current = i + 1;
                lastReturned = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }
    private class CustomIterator implements Iterator<E>{
        int current;
        int lastReturned = -1;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return current != size;
        }

        @Override
        public E next() {
            checkForComodification();
            int i = current;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = CustomArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            current = i + 1;
            return (E) elementData[lastReturned = i];
        }

        @Override
        public void remove() {
            if (lastReturned < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                CustomArrayList.this.remove(lastReturned);
                current = lastReturned;
                lastReturned = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
