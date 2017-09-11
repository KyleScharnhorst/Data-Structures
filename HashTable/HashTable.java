import java.util.ArrayList;
public class HashTable<T extends Comparable<T>> {
    private int _table_size = 0;
    private ArrayList<BinarySearchTree<T>> _table;
    
    // @SuppressWarnings("unchecked")
    public HashTable(int table_size) {
        this._table_size = table_size;
        _table = new ArrayList<BinarySearchTree<T>>();
        for (int i = 0; i < table_size; i++) {
            _table.add(new BinarySearchTree<T>());
        }
    }

    private int getTableIndex(T data) {
        return data.hashCode() % this._table_size;
    }

    private BinarySearchTree<T> getBST(T data) {
        return _table.get(getTableIndex(data));
    }

    public boolean insert(T data) {
        return getBST(data).insert(data) != null;
    }

    public T find(T data) {
        return getBST(data).find(data);
    }

    public static void main(String[] args) {
        System.out.println("Running...");
        HashTable<Integer> ht = new HashTable<Integer>(100);
        assert ht.insert(1024);
        assert ht.insert(16);
        assert !ht.insert(16);
        assert ht.find(1024) == 1024;
        System.out.println("Complete.");
    }
}