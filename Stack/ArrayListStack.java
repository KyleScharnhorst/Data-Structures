import java.util.ArrayList;

public class ArrayListStack<T> {
    ArrayList<T> _stack = new ArrayList<T>();

    public boolean push(T element) {
        return _stack.add(element);
    }

    public T pop() {
        T result = null;
        if(this.hasElements()) {
            result = _stack.remove(_stack.size() - 1);
        }
        return result;
    }

    private boolean hasElements() {
        boolean result = false;
        if(_stack.size() > 0) {
            result = true;
        }
        return result;
    }

    public T peek() {
        T result = null;
        if(this.hasElements()) {
            result = _stack.get(_stack.size() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayListStack<Integer> stack = new ArrayListStack<Integer>();
        System.out.println("Running...");
        assert stack.push(1) == true;
        assert stack.peek() == 1;
        assert stack.push(2) == true;
        assert stack.pop() == 2;
        assert stack.peek() == 1; 
        assert stack.pop() == 1;
        assert stack.peek() == null;
        assert stack.pop() == null;
        System.out.println("Finished.");
    }
}