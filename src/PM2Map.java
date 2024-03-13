import java.util.Collection;
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

    @Override
    public V put(K key, V value) {
        if(value == null || key == null){
            return null;
        }
        if(paare.length == 0){
            paare = new MapPaar[1];
            paare[0] = new MapPaar<>(key, value);
            counter++;
            return value;
        }
        for(int i = 0; i < paare.length; i++){
            if(paare[i] == null){
                paare[i] = new MapPaar<>(key, value);
                counter++;
                return value;
            } else if(paare[i].getKey() == key){
                paare[i].setValue(value);
                return value;
            }
        }
        if(counter == paare.length){
            //hier verdoppeln
            MapPaar<K,V>[] tmp  = new MapPaar[paare.length*2];
            System.arraycopy(paare, 0, tmp, 0, paare.length);
            paare = tmp;
            paare[counter] = new MapPaar<>(key, value);
            counter++;
        }
        return value;
    }

    @Override
    public V remove(Object key) {
        for(int i = 0; i < paare.length; i++){
            if(!paare[i].getKey().equals(key)){
                return null;
            }
            if(paare[i].getKey().equals(key)){

            }
        }
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
