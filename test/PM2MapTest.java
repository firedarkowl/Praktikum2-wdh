import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PM2MapTest {

    @Test
    public void testSize() {
        List l = new ArrayList<>();
        PM2Map<String, Integer> map = new PM2Map<>();
        assertEquals(0, map.size());

        map.put("A", 1);
        assertEquals(1, map.size());
    }

    @Test
    public void testIsEmpty() {
        PM2Map<String, Integer> map = new PM2Map<>();
        assertTrue(map.isEmpty());

        map.put("A", 1);
        assertFalse(map.isEmpty());
    }

    @Test
    public void testContainsKey() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("A", 1);
        assertTrue(map.containsKey("A"));
        assertFalse(map.containsKey("B"));
    }

    @Test
    public void testContainsValue() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("A", 1);
        assertTrue(map.containsValue(1));
        assertFalse(map.containsValue(2));
    }

    @Test
    public void testGet() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("A", 1);
        assertEquals(Integer.valueOf(1), map.get("A"));
        assertNull(map.get("B"));
    }

    @Test
    public void testPut() {
        PM2Map<String, Integer> map = new PM2Map<>();
        assertNull(map.put("A", 1));
        assertEquals(Integer.valueOf(1), map.put("A", 2));
    }

    @Test
    public void testRemoveExistingKey() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);

        Integer removedValue = map.remove("A");

        assertNull(map.get("A"));
        assertEquals(Integer.valueOf(1), removedValue);
    }

    @Test
    public void testRemoveNonExistingKey() {
        Map<String, Integer> map = new HashMap<>();

        Integer removedValue = map.remove("B");

        assertNull(removedValue);
    }


    @Test
    public void testPutNullKey() {
        PM2Map<String, Integer> map = new PM2Map<>();
        try {
            map.put(null, 1);
            fail("Expected IllegalArgumentException for putting null key");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testPutNullValue() {
        PM2Map<String, Integer> map = new PM2Map<>();
        try {
            map.put("A", null);
            fail("Expected IllegalArgumentException for putting null value");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testRemoveNonExistentKey() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("A", 1);
        assertNull(map.remove("B"));
    }

    @Test
    public void testClear() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("A", 1);
        map.put("B", 2);
        map.clear();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    public void testPutAll() {
        PM2Map<String, Integer> map = new PM2Map<>();
        assertEquals(0, map.size());
        Map<String, Integer> otherMap = new HashMap<>();
        otherMap.put("A", 1);
        otherMap.put("B", 2);
        map.putAll(otherMap);
        assertEquals(2, map.size());
        assertTrue(map.containsKey("A"));
        assertTrue(map.containsKey("B"));
    }

    @Test
    public void testPutAllWithExisting() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("C", 3);
        assertEquals(1, map.size());
        Map<String, Integer> otherMap = new HashMap<>();
        otherMap.put("A", 1);
        otherMap.put("B", 2);
        map.putAll(otherMap);
        assertEquals(3, map.size());
        assertTrue(map.containsKey("A"));
        assertTrue(map.containsKey("B"));
        assertTrue(map.containsKey("C"));
    }

    @Test
    public void testKeySet() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("A", 1);
        map.put("B", 2);
        Set<String> keySet = map.keySet();
        assertEquals(2, keySet.size());
        assertTrue(keySet.contains("A"));
        assertTrue(keySet.contains("B"));
    }

    @Test
    public void testValues() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("A", 1);
        map.put("B", 2);
        Collection<Integer> values = map.values();
        assertEquals(2, values.size());
        assertTrue(values.contains(1));
        assertTrue(values.contains(2));
    }

    @Test
    public void testArrayDoubling() {
        PM2Map<String, Integer> map = new PM2Map<>();
        for (int i = 0; i < 20; i++) {
            map.put(String.valueOf(i), i);
        }
        assertEquals(20, map.size());
    }

    @Test
    public void testEntrySet() {
        PM2Map<String, Integer> map = new PM2Map<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        assertEquals(3, map.entrySet().size());
    }
}
