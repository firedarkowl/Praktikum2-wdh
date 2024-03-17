import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PM2Map<K,V> implements Map<K,V> {

    private int counter = 0;
    MapPaar<K,V>[] paare = new MapPaar[0];

    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        if(paare.length == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        for(int i = 0; i < paare.length; i++){
            if(paare[i]==null){
                return false;
            }
            if(paare[i].getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(int i = 0; i < paare.length; i++){
            if(paare[i]==null){
                return false;
            }
            if(paare[i].getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for(int i = 0; i < paare.length; i++){
            if(paare[i].getKey().equals(key)){
                return paare[i].getValue();
            }
        }
        return null;
    }

    //muss das vorherige Value zurückgeben
    @Override
    public V put(K key, V value) {
        if(value == null || key == null){
            throw new IllegalArgumentException();
        }
        if(paare.length == 0){
            paare = new MapPaar[1];
            paare[0] = new MapPaar<>(key, value);
            counter++;
            return null;
        }
        for(int i = 0; i < paare.length; i++){
            if(paare[i] == null){
                paare[i] = new MapPaar<>(key, value);
                counter++;
                return value;
            } else if(paare[i].getKey() == key){
                V prevValue = paare[i].getValue();
                paare[i].setValue(value);
                return prevValue;
            }
        }
        if(counter == paare.length){
            //hier verdoppeln
            V prevValue = paare[counter - 1].getValue();
            MapPaar<K,V>[] tmp  = new MapPaar[paare.length*2];
            System.arraycopy(paare, 0, tmp, 0, paare.length);
            paare = tmp;
            paare[counter] = new MapPaar<>(key, value);
            counter++;
            return prevValue;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = 0;
        for(int i = 0 ; i < paare.length; index++){
            if((paare[index]).equals(key)){
                index = i;
            }
            if(((i+1) == paare.length) && !paare[i].equals(key)){
                return null;
            }
        }
        V valueToRemove = paare[index].getValue();
        paare[index] = null;
        MapPaar<K, V>[] tmp = new MapPaar[paare.length];
        for(int i = 0; i < paare.length; i++){
            for(int j = 0; j < tmp.length; j++){
                if(paare[i] != null){
                    tmp[j] = paare[i];
                }
            }
        }
        counter--;
        paare = tmp;
        return valueToRemove;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> e : m.entrySet()) {
            K key = e.getKey();
            V value = e.getValue();
            put(key, value);
        }
    }

    @Override
    public void clear() {
        MapPaar<K, V>[] tmp = new MapPaar[0];
        for(int  i = 0; i < paare.length; i++){
            paare[i] = null;
        }
        paare = tmp;
        counter = 0;
    }

    @Override
    public Set keySet() {
        Set keys = new HashSet();
        for(int i = 0; i < paare.length; i++){
            if(paare[i] == null){
                return keys;
            }
            keys.add(paare[i].getKey());
        }
        return keys;
    }

    @Override
    public Collection values() {
        Collection<V> values = new HashSet<>();
        for(int i = 0; i < paare.length; i++){
            if(paare[i] == null){
                return values;
            }
            values.add(paare[i].getValue());
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        for(int i = 0; i < paare.length; i++){
            if(paare[i] == null){
                return entries;
            }
            entries.add(paare[i]);
        }
        return entries;
    }
}
