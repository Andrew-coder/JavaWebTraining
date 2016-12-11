import java.util.*;

/**
 * Created by andri on 12/11/2016.
 */
public class CustomHashMap<K, V> implements Map<K, V> {
    private int capacity = 16;
    private Node<K,V>[] array;
    private int size = 0;
    private double loadFactor=0.75;
    int threshold;

    public CustomHashMap(int initialCapacity, double loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        if (loadFactor <= 0 || Double.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        array = (Node<K, V>[]) new Node[initialCapacity];
        this.loadFactor = loadFactor;
        this.threshold = (int)(capacity*loadFactor);
    }

    public CustomHashMap(int initialCapacity) {
        this(initialCapacity, 0.75);
    }

    public CustomHashMap() {
        this.loadFactor = 0.75;
        array = (Node<K, V>[]) new Node[capacity];
    }


    public int size() {
        return size;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean containsKey(Object key) {
        int bucket = calculateBucketNumber(key.hashCode(), array);
        if (array[bucket] == null) {
            return false;
        }
        Node<K, V> current = array[bucket];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    int calculateBucketNumber(Node<K, V> entry, Node<K, V>[] array) {
        return Math.abs(entry.hash % array.length);
    }

    int calculateBucketNumber(int hash, Node<K, V>[] array) {
        return Math.abs(hash % array.length);
    }

    public boolean containsValue(Object value) {
        for (Node<K, V> el : array) {
            if (el != null) {
                Node<K, V> current = el;
                while (current != null) {
                    if (current.value.equals(value)) {
                        return true;
                    }
                    current = current.next;
                }
            }
        }
        return false;
    }

    public V get(Object key) {
        Objects.requireNonNull(key);
        for(Node<K,V> node:array){
            if(key.equals(node.key))
                return node.value;
        }
        return null;
    }

    public V put(K key, V value) {
        Node<K, V> newEntry = new Node<K, V>(key, value);
        if (size == array.length) {
            expand();
        }
        int bucket = calculateBucketNumber(key.hashCode(), array);
        if (array[bucket] == null) {
            array[bucket] = newEntry;
            size++;
            return null;
        }
        Node<K, V> current = array[bucket];
        Node<K, V> previous = current;
        while (current != null) {
            if (current.key.equals(key)) {
                V old = current.value;
                current.value = value;
                return old;
            }
            previous = current;
            current = current.next;
        }
        previous.next = newEntry;
        size++;
        return null;
    }

    private void expand() {
        Node<K, V>[] newArray = (Node<K, V>[]) new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                Node<K, V> current = array[i];
                Node<K, V> previous = current;
                while (current != null) {
                    placeEntryToArray(current, newArray);
                    previous = current;
                    current = current.next;
                    previous.next = null;
                }
            }
        }
        array = newArray;
    }

    private void placeEntryToArray(Node<K, V> entry, Node<K, V>[] array) {
        int bucket = calculateBucketNumber(entry, array);
        if (array[bucket] == null) {
            array[bucket] = entry;
        } else {
            Node<K, V> current = array[bucket];
            Node<K, V> previous = current;
            while (current != null) {
                previous = current;
                current = current.next;
            }
            previous.next = entry;
        }
    }

    public V remove(Object key) {
        int bucket = calculateBucketNumber(key.hashCode(), array);
        if (array[bucket] == null) {
            return null;
        } else {
            Node<K, V> current = array[bucket];
            Node<K, V> previous = current;
            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous != current) {
                        previous.next = current.next;
                    } else {
                        array[bucket] = current.next;
                    }
                    size--;
                    return current.value;
                }

                previous = current;
                current = current.next;
            }
        }
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> m) {

    }

    public void clear() {

    }

    public Set<K> keySet() {
        return null;
    }

    public Collection<V> values() {
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    static class Node<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value) {
            hash = key.hashCode();
            this.key = key;
            this.value = value;
        }

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (key.equals(e.getKey()) &&
                        value.equals(e.getValue()))
                    return true;
            }
            return false;
        }
    }
}
