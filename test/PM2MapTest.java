import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class PM2MapTest {

    @Test
    void testEmptyMap() {
        PM2Map<String, Integer> map = new PM2Map<>();
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    void testPutAndGet() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        assertEquals(1, map.get("key1"));
        assertEquals(2, map.get("key2"));
        assertEquals(3, map.get("key3"));
    }

    @Test
    void testContainsKey() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        assertTrue(map.containsKey("key1"));
        assertFalse(map.containsKey("key4"));
    }

    @Test
    void testContainsValue() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        assertTrue(map.containsValue(1));
        assertFalse(map.containsValue(4));
    }

    @Test
    void testRemove() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        assertEquals(1, map.remove("key1"));
        assertFalse(map.containsKey("key1"));
    }

    @Test
    void testSize() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        assertEquals(3, map.size());
    }

    @Test
    void testClear() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        map.clear();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    void testNullKey() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put(null, 1);

        assertEquals(1, map.get(null));
        assertTrue(map.containsKey(null));
    }

    @Test
    void testNullValue() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("key1", null);

        assertNull(map.get("key1"));
        assertTrue(map.containsValue(null));
    }
}
