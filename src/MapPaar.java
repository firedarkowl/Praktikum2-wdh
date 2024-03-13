import java.util.Map;

public class MapPaar <K, V> implements Map.Entry  <K, V>{

    private K key;
    private V value;

    public MapPaar(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        return value = value;
    }
}
