import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class KeyableMap<T, K, V extends Keyable<K>> implements Keyable<T>{
    protected T key;
    protected Map<K,V> map;

    public KeyableMap(T key) {
        this.key = key;
        this.map = new HashMap<>();
    }

    KeyableMap<T, K, V> put(V item) {
        this.map.put(item.getKey(), item);
        return this;
    }

    public Optional<V> get(K k) {
        if (this.map.containsKey(k)){
            return Optional.of(this.map.get(k));
        } else {
            return Optional.empty();
        }
    }

    
    @Override
    public T getKey() {
        return this.key;
    }

    @Override
    public String toString() {
        return (this.key + ": " + map.values()).replace("[","{").replace("]","}");
        }
}