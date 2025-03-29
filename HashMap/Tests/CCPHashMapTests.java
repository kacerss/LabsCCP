import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CCPHashMapTests {
    @Test
    public void testSetup() {
        CCPHashMap map = new CCPHashMap();
        Assertions.assertEquals(0, map.size());
    }

    @Test
    public void testPut() {
        CCPHashMap map = new CCPHashMap();
        Assertions.assertEquals(0, map.put("A", 10));
        Assertions.assertEquals(0, map.put("B", 20));
        Assertions.assertEquals(0, map.put("C", 30));
        Assertions.assertEquals(0, map.put("D", 40));
        Assertions.assertEquals(0, map.put("E", 50));
        Assertions.assertEquals(10, map.put("A", 60));
        Assertions.assertEquals(20, map.put("B", 70));
        Assertions.assertEquals(30, map.put("C", 80));
        Assertions.assertEquals(40, map.put("D", 90));
        Assertions.assertEquals(50, map.put("E", 100));
    }

    @Test
    public void testGet() {
        CCPHashMap map = new CCPHashMap();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("D", 40);
        map.put("E", 50);
        Assertions.assertEquals(10, map.get("A"));
        Assertions.assertEquals(20, map.get("B"));
        Assertions.assertEquals(30, map.get("C"));
        Assertions.assertEquals(40, map.get("D"));
        Assertions.assertEquals(50, map.get("E"));

        map.put("A", 60);
        map.put("B", 70);
        map.put("C", 80);
        map.put("D", 90);
        map.put("E", 100);
        Assertions.assertEquals(60, map.get("A"));
        Assertions.assertEquals(70, map.get("B"));
        Assertions.assertEquals(80, map.get("C"));
        Assertions.assertEquals(90, map.get("D"));
        Assertions.assertEquals(100, map.get("E"));

    }

    @Test
    public void testSize() {
        CCPHashMap map = new CCPHashMap();
        Assertions.assertEquals(0, map.size());
        map.put("A", 10);
        map.put("B", 20);
        Assertions.assertEquals(2, map.size());
        map.put("C", 30);
        map.put("D", 40);
        map.put("E", 50);
        Assertions.assertEquals(5, map.size());
        map.put("C", 60);
        Assertions.assertEquals(5, map.size());
    }

    @Test
    public void testContainsKey() {
        CCPHashMap map = new CCPHashMap();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        Assertions.assertTrue(map.containsKey("A"));
        Assertions.assertTrue(map.containsKey("B"));
        Assertions.assertTrue(map.containsKey("C"));
        Assertions.assertFalse(map.containsKey("D"));
    }

    @Test
    public void testLoad() {
        CCPHashMap map = new CCPHashMap();
        map.put("A", 10);
        Assertions.assertEquals(0.25, map.load(), 0.00001);
        map.put("B", 20);
        Assertions.assertEquals(0.5, map.load(), 0.00001);
        map.put("C", 30);
        Assertions.assertEquals(0.75, map.load(), 0.00001);
        map.put("D", 40);
        Assertions.assertEquals(1.0, map.load(), 0.00001);
        map.put("D", 50);
        Assertions.assertEquals(1.0, map.load(), 0.00001);
        map.put("E", 40);
        Assertions.assertEquals(5.0 / 8.0, map.load(), 0.00001);
    }

    public static boolean contains(String s, String[] list) {
        for (String key : list) {
            if (key.equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testKeys() {
        CCPHashMap map = new CCPHashMap();
        String[] testKeys = {"A", "B" ,"C", "D", "E"};
        int value = 0;
        for (String key : testKeys) {
            value += 10;
            map.put(key, value);
        }
        map.put("D", 60);
        map.put("E", 70);
        String[] keys = map.keys();
        Assertions.assertEquals(5, keys.length);
        for (String key : testKeys) {
            Assertions.assertTrue(contains(key, keys));
        }

    }

}
