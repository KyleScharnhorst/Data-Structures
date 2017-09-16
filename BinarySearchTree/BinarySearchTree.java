public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> _head = null;

    public TreeNode<T> insert(T data) {
        if(_head == null) {
            _head = new TreeNode<>(data);
            return _head;
        }
        return insert(data, _head);
    }
    /**
     * node on success and null for duplicate.
     */
    private TreeNode<T> insert(T data, TreeNode<T> node) {
        int comparison = data.compareTo(node._data);
        if(comparison < 0) {
            if(node._left_node == null) {
                return (node._left_node = new TreeNode<>(data));
            } else {
                return insert(data, node._left_node);
            }
        } else if (comparison > 0) {
            if (node._right_node == null) {
                return (node._right_node = new TreeNode<>(data));
            } else {
                return insert(data, node._right_node);
            }
        } else {
            return null;
        }
    }

    public T find(T data) {
        return find(data, _head);
    }

    private T find(T data, TreeNode<T> node) {
        T result = null;

        if(node != null) {
            int comparison = data.compareTo(node._data);
            if(comparison < 0) {
                result = find(data, node._left_node);
            } else if (comparison > 0) {
                result = find(data, node._right_node);
            } else {
                result = node._data;
            }
        }

        return result;
    }

    private class TreeNode<T extends Comparable<T>> {
        public T _data;
        public TreeNode<T> _left_node;
        public TreeNode<T> _right_node;

        public TreeNode(T data) {
            this._data = data;
        }

        public String toString() {
            return "Data: " + _data + ", left_node: (" + _left_node +
            "), right_node: (" + _right_node + ")";
        }
    }

    public void printInOrder() {
        System.out.print("InOrder: ");
        printInOrder(this._head);
        System.out.println();
    }

    private void printInOrder(TreeNode<T> node) {
        if(node != null) {
            printInOrder(node._left_node);
            System.out.print(node._data + " ");
            printInOrder(node._right_node);
        }
    }

    public void printPreOrder() {
        System.out.print("PreOrder: ");
        printPreOrder(this._head);
        System.out.println();
    }

    private void printPreOrder(TreeNode<T> node) {
        if(node != null) {
            System.out.print(node._data + " ");
            printPreOrder(node._left_node);
            printPreOrder(node._right_node);
        }
    }

    public void printPostOrder() {
        System.out.print("PostOrder: ");
        printPostOrder(this._head);
        System.out.println();
    }

    private void printPostOrder(TreeNode<T> node) {
        if(node != null) {
            printPostOrder(node._left_node);
            printPostOrder(node._right_node);
            System.out.print(node._data + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        System.out.println("Running...");
        /* BST structure
         *                      5
         *                   2      6
         *                              7
         *                                  12
         *                               11
         *                            8
         *                               9
         *                                  10
         */
        assert bst.insert(5) != null;
        assert bst._head != null;
        assert bst.insert(5) == null;
        assert bst.insert(6) != null;
        assert bst.insert(2) != null;
        assert bst.insert(7) != null;
        assert bst.insert(12) != null;
        assert bst.insert(11) != null;
        assert bst.insert(8) != null;
        assert bst.insert(9) != null;
        assert bst.insert(10) != null;
        System.out.println("Find result: " + bst.find(10));
        System.out.println(bst._head);
        bst.printInOrder();
        bst.printPreOrder();
        bst.printPostOrder();
    }
}