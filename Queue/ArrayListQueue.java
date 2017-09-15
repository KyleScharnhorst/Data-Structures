import java.util.ArrayList;

public class ArrayListQueue<T> {
    ArrayList<T> _queue = new ArrayList<T>();

    private boolean hasElements() {
        return !_queue.isEmpty();
    }

    public T peek() {
        T result = null;
        if(this.hasElements()) { result = _queue.get(0); }
        return result;
    }

    public boolean push(T element) {
        return _queue.add(element);
    }

    public T pop() {
        T result = null;
        if(this.hasElements()) { result = _queue.remove(0); }
        return result;
    }

    public static void main(String[] args) {
        ArrayListQueue<Integer> queue = new ArrayListQueue<Integer>();
        System.out.println("Running...");
        assert queue.peek() == null;
        assert queue.pop() == null;
        assert queue.push(1) == true;
        assert queue.peek() == 1;
        assert queue.push(2) == true;
        assert queue.peek() == 1;
        assert queue.pop() == 1;
        assert queue.peek() == 2;
        assert queue.pop() == 2;
        assert queue.peek() == null;
        assert queue.pop() == null;
        System.out.println("Finished.");
    }
}