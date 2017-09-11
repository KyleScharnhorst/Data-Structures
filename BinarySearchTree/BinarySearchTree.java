public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> _head = null;

    public TreeNode<T> insert(T data) {
        if(_head == null) {
            _head = new TreeNode<T>(data);
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
                return (node._left_node = new TreeNode<T>(data));
            } else {
                return insert(data, node._left_node);
            }
        } else if (comparison > 0) {
            if (node._right_node == null) {
                return (node._right_node = new TreeNode<T>(data));
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

        if(node == null) {
            result = null;
        } else {
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

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        System.out.println("Running...");
        // assertNotNull(bst.insert(5));
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
    }
}