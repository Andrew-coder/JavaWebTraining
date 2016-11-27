import java.util.*;

/**
 * Created by andri on 11/27/2016.
 */
public class CustomTreeSet<E extends Comparable> implements NavigableSet<E> {
    private int size;
    private Node<E> root;

    public CustomTreeSet() {
        size = 0;
        root = new Node<>();
    }

    private Node<E> detacheTheRightestNode(Node<E> targetNode){
        Node<E> currentNode = targetNode;
        while (true){
            if(currentNode.rightNode!=null)
                currentNode=currentNode.rightNode;
            else break;
        }
        if(hasLeftChild(currentNode)){
            relinkParentNode(currentNode.leftNode, currentNode);
            currentNode.leftNode=null;
        }
        return currentNode;
    }

    private void relinkParentNode(Node<E> targetNode, Node<E> deletedNode){
        if(deletedNode!=root) {
            if (deletedNode.parentNode.leftNode == deletedNode) {
                deletedNode.parentNode.leftNode = targetNode;
            } else {
                deletedNode.parentNode.rightNode = targetNode;
            }
            if(targetNode!=null)
                targetNode.parentNode = deletedNode.parentNode;
        }
        else {
            if(targetNode!=null) {
                targetNode.leftNode = deletedNode.leftNode;
                targetNode.rightNode = deletedNode.rightNode;
                root = targetNode;
                root = targetNode;
            }
            else root=null;
        }
    }

    private void unlinkNode(Node<E> targetNode) {
        if (hasBothChild(targetNode)) {
            Node<E> node = detacheTheRightestNode(targetNode.leftNode);
            node.leftNode=targetNode.leftNode;
            node.rightNode=targetNode.rightNode;
            node.leftNode.parentNode=node;
            node.rightNode.parentNode=node;
            relinkParentNode(node, targetNode);

            targetNode = null;
        } else if (hasLeftChild(targetNode)) {
            relinkParentNode(targetNode.leftNode, targetNode);
            targetNode.leftNode.parentNode=targetNode.parentNode;
            targetNode = null;
        } else if (hasRightChild(targetNode)) {
            relinkParentNode(targetNode.rightNode, targetNode);
            targetNode.rightNode.parentNode=targetNode.parentNode;
            targetNode = null;
        } else {
            relinkParentNode(null, targetNode);
            targetNode=null;
        }
    }

    private boolean hasLeftChild(Node<E> targetNode){
        if(targetNode.leftNode!=null) {
            return true;
        }
        return false;
    }

    private boolean hasRightChild(Node<E> targetNode){
        if(targetNode.rightNode!=null) {
            return true;
        }
        return false;
    }

    private boolean hasBothChild(Node<E> targetNode){
        if(targetNode.leftNode!=null && targetNode.rightNode!=null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean contains(Object o) {
        Objects.requireNonNull(o, "CustomTreeSet class: contains(): method parameter shouldn't be 'null'!");
        E searchObject = (E) o;
        Node<E> currentNode = root;
        while (currentNode != null) {
            int compareResult = searchObject.compareTo(currentNode.dataObject);
            if (compareResult == 0) {
                return true;
            } else if (compareResult < 0) {
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }
        }
        return false;
    }



    @Override
    public boolean add(E e) {
        Objects.requireNonNull(e);
        size++;
        if(root.dataObject==null){
            root.dataObject = e;
            return true;
        }
        else{
            Node<E> currentNode = root;
            while(true){
                int compareResult = e.compareTo(currentNode.dataObject);
                if(compareResult==0) return false;
                else if(compareResult<0) {
                    if (currentNode.leftNode != null) {
                        currentNode = currentNode.leftNode;
                    } else {
                        currentNode.leftNode = new Node<>(e);
                        currentNode.leftNode.parentNode = currentNode;
                        return true;
                    }
                }
                else{
                    if (currentNode.rightNode != null) {
                        currentNode = currentNode.rightNode;
                    } else {
                        currentNode.rightNode = new Node<>(e);
                        currentNode.rightNode.parentNode = currentNode;
                        return true;
                    }
                }
            }
        }
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public boolean remove(Object o) {
        Objects.requireNonNull(o);
        E removedObject = (E) o;
        if (size == 0){
            return false;
        }
        Node<E> currentNode = root;
        while (currentNode != null) {
            int compareResult = currentNode.dataObject.compareTo(removedObject);
            if (compareResult == 0) {
                unlinkNode(currentNode);
                size--;
                return true;
            }
            else if (compareResult < 0) {
                currentNode = currentNode.rightNode;
            } else {
                currentNode = currentNode.leftNode;
            }
        }
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    public boolean addAll(Collection c) {
        return false;
    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public void clear() {

    }

    public Iterator<E> iterator() {
        return null;
    }

    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public E lower(E e) {
        return null;
    }

    @Override
    public E floor(E e) {
        return null;
    }

    @Override
    public E ceiling(E e) {
        return null;
    }

    @Override
    public E higher(E e) {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public NavigableSet<E> descendingSet() {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return null;
    }

    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return null;
    }

    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return null;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return null;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        return null;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        return null;
    }

    @Override
    public Comparator<? super E> comparator() {
        return null;
    }

    @Override
    public E first() {
        return null;
    }

    @Override
    public E last() {
        return null;
    }

    private class Node<E>{
        Node<E> parentNode;
        Node<E> leftNode;
        Node<E> rightNode;
        E dataObject;

        public Node() {
        }

        public Node(E dataObject) {
            this.dataObject = dataObject;
        }

        public Node(Node<E> parentNode, Node<E> leftNode, Node<E> rightNode, E dataObject) {
            this.parentNode = parentNode;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.dataObject = dataObject;
        }

        public Node<E> getParentNode() {
            return parentNode;
        }

        public void setParentNode(Node<E> parentNode) {
            this.parentNode = parentNode;
        }

        public Node<E> getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node<E> leftNode) {
            this.leftNode = leftNode;
        }

        public Node<E> getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node<E> rightNode) {
            this.rightNode = rightNode;
        }

        public E getDataObject() {
            return dataObject;
        }

        public void setDataObject(E dataObject) {
            this.dataObject = dataObject;
        }
    }
}
