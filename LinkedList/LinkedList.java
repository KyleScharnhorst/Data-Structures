/**
 * This class provides a basic implementation of a linked list.
 */
import java.lang.StringBuilder;

public class LinkedList {
    public LinkedListNode _head_node = null;
    public LinkedListNode _tail_node = null;

    public void appendToTail(int data) {
        if (_head_node == null) {
            _head_node = new LinkedListNode(data);
            _tail_node = _head_node;
        } else {
            _tail_node._next_node = new LinkedListNode(data);
            _tail_node = _tail_node._next_node;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedListNode temp_node = _head_node;

        while(temp_node != null) {
           sb.append(String.valueOf(temp_node._data) + ", ");
           temp_node = temp_node._next_node;
        }
        
        return sb.toString();
    }

    public class LinkedListNode {
        public int _data = 0;
        public LinkedListNode _next_node = null;

        public LinkedListNode (int data) {
            this._data = data;
        }
    }

    /**
     * Main for testing functionality.
     */
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        System.out.println(l.toString());
        l.appendToTail(1);
        l.appendToTail(2);
        l.appendToTail(3);
        l.appendToTail(4);
        System.out.println(l.toString());
    }
}