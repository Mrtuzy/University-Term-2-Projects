import  java.util.Iterator;
public interface ITree<T extends Comparable<? super T>> {
    T add(Node<T> rootNode, T newEntry);
    public boolean search(Node<T> root,T newEntry);
    public void list();
    public boolean contains(T entry);
    public T getEntry(T entry);
    public  Node<T> remove (Node<T> root,T entry);
    public Iterator<T> getInorderIterator();
    public Node<T> getRoot();
}
