public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T data) {
        this(data,null,null);
    }
    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
    public boolean hasLeftChild() {
        return left != null;
    }
    public boolean hasRightChild() {
        return right != null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public int getNumberOfNodes() {
        int leftNumber = 0;
        int rightNumber = 0;
        if (hasLeftChild()) {
            leftNumber = left.getNumberOfNodes();
        }
        if (hasRightChild()) {
            rightNumber = right.getNumberOfNodes();
        }
        return 1 + leftNumber + rightNumber;
    }

    public Node<T> copy() {
        Node<T> newRoot = new Node<>(data);
        if (hasLeftChild()) {
            newRoot.setLeft(left.copy());
        }
        if (hasRightChild()) {
            newRoot.setRight(right.copy());
        }
        return newRoot;
    }

}
