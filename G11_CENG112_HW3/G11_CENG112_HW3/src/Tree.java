import java.util.Iterator;

public class Tree<T extends Comparable<T>> implements ITree<T> {
    private Node<T> root;

    public Tree() {
        root = null;
    }

    public Tree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }



    @Override
    public boolean contains(T entry) {
        return getEntry(entry) != null;
    }

    @Override
    public T getEntry(T entry) {
        return findEntry(getRoot(), entry);
    }

    @Override
    public Node<T> remove(Node<T> root, T entry) {
        return null;
    }

    @Override
    public Iterator<T> getInorderIterator() {
        return null;
    }

    private boolean isEmpty() {
        return root == null;
    }

    private void setRootNode(Node<T> rootNode){
        root = rootNode;
    }


    private T findEntry(Node<T> root, T entry) {
        T result = null;
        if (root != null) {
            T rootEntry = root.getData();
            if (entry.equals(rootEntry)) {
                result = rootEntry;
            } else if (entry.compareTo(rootEntry) < 0) {
                result = findEntry(root.getLeft(), entry);
            } else {
                result = findEntry(root.getRight(), entry);
            }
        }
        return result;
    }

    public T add(Node<T> rootNode, T newEntry) {
        T result = null;
        if (isEmpty()){
            setRootNode(new Node<>(newEntry));
        } else {
            result = addEntry(rootNode, newEntry);
        }
        return result;
    }

    private T addEntry(Node<T> rootNode, T newEntry) {
        assert rootNode != null;
        T result = null;
        int comparison = newEntry.compareTo(rootNode.getData());

        if (comparison == 0) {
            result = rootNode.getData();
            rootNode.setData(newEntry);

        } else if (comparison < 0) {
            if (rootNode.hasLeftChild()) {
                result = add(rootNode.getLeft(), newEntry);
            } else {
                rootNode.setLeft(new Node<>(newEntry));
            }


        } else {
            assert comparison > 0;

            if (rootNode.hasRightChild()) {
                result = add(rootNode.getRight(), newEntry);
            } else {
                rootNode.setRight(new Node<>(newEntry));
            }

        }
        return result;
    }



    @Override
    public boolean search(Node<T> root,T newEntry) {
      if(root == null){
        return false;
      }
      if(root.getData().equals(newEntry)){
        return true;
      }
        if(newEntry.compareTo(root.getData()) < 0){
            return search(root.getLeft(),newEntry);
        }else{
            return search(root.getRight(),newEntry);
        }

    }

    public boolean searchWithTraversal(Node<T> root, T newEntry) {
        if (root == null) {
            return false;
        }
        if (root.getData().equals(newEntry)) {
            return true;
        }
        // Search in the left subtree
        boolean foundInLeftSubtree = searchWithTraversal(root.getLeft(), newEntry);
        if (foundInLeftSubtree) {
            return true;
        }
        // Search in the right subtre
        return searchWithTraversal(root.getRight(), newEntry);
    }



    @Override
    public void list() {
        listRecursive(root);
    }

    private void listRecursive(Node<T> node) {
        if (node != null) {
            listRecursive(node.getLeft());
            System.out.println(node.getData());
            listRecursive(node.getRight());
        }
    }

    public Node<T> removeEntry(Node<T> rootNode, T entry , T oldEntry){
       if(rootNode != null){
              T rootData = rootNode.getData();
              int comparison = entry.compareTo(rootData);
              if(comparison == 0){
                rootNode = removeFromRoot(rootNode);
              }else if(comparison < 0){
                Node<T> leftChild = rootNode.getLeft();
                Node<T> newLeftChild = removeEntry(leftChild,entry,oldEntry);
                rootNode.setLeft(newLeftChild);
              }else{
                Node<T> rightChild = rootNode.getRight();
                Node<T> newRightChild = removeEntry(rightChild,entry,oldEntry);
                rootNode.setRight(newRightChild);
              }
       }
         return rootNode;
    }

    private Node<T> removeFromRoot(Node<T> root) {
        if (root.hasLeftChild() && root.hasRightChild()) {
            Node<T> leftSubtreeRoot = root.getLeft();
            Node<T> largestNode = findLargest(leftSubtreeRoot);
            root.setData(largestNode.getData());
            root.setLeft(removeLargest(leftSubtreeRoot));
        } else if (root.hasRightChild()) {
            root = root.getRight();
        } else {
            root = root.getLeft();
        }
        return root;
    }

    private Node<T> findLargest(Node<T> rootNode){
        if(rootNode.hasRightChild()){
            rootNode = findLargest(rootNode.getRight());
        }
        return rootNode;
    }

    private Node<T> removeLargest(Node<T> rootNode){
        if(rootNode.hasRightChild()){
            Node<T> rightChild = rootNode.getRight();
            Node<T> root = removeLargest(rightChild);
            rootNode.setRight(root);
        }else{
            rootNode = rootNode.getLeft();
        }
        return rootNode;
    }




}







