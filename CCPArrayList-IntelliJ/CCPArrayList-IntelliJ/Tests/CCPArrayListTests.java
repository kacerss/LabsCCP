import org.junit.Test;
import org.junit.Assert;

public class CCPArrayListTests {

    @Test
    public void testSetup() {
        CCPArrayList<Integer> list = new CCPArrayList<Integer>();
        Assert.assertEquals(0, list.size());
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testAdd() {
        CCPArrayList<Integer> list = new CCPArrayList<Integer>();
        Assert.assertEquals(4, list.getRealSize());
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        Assert.assertEquals(8, list.getRealSize());
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
        Assert.assertEquals(16, list.getRealSize());
        int value = 10;
        for (Integer i : list) {
            Assert.assertEquals(value, i.intValue());
            value += 10;
        }
    }

    @Test
    public void testAddAtPosition() {
        CCPArrayList<Integer> list = new CCPArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i * 10);
        }
        list.add(0, 100);
        Assert.assertEquals(10, list.size());
        list.add(5, 200);
        Assert.assertEquals(11, list.size());
        list.add(11, 300);
        Assert.assertEquals(12, list.size());
        int[] values = {100, 10, 20, 30, 40, 200, 50, 60, 70, 80, 90, 300};
        for (int i = 0; i < 12; i++) {
            Assert.assertEquals(values[i], list.get(i).intValue());
        }
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.add(13, 100));
    }

    @Test
    public void testRemove() {
        CCPArrayList<Integer> list = new CCPArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            list.add(i * 10);
        }
        Assert.assertEquals(10, list.size());
        Assert.assertEquals(16, list.getRealSize());

        Assert.assertEquals(10, list.remove(0).intValue());
        Assert.assertEquals(9, list.size());
        Assert.assertEquals(16, list.getRealSize());

        Assert.assertEquals(20, list.remove(0).intValue());
        Assert.assertEquals(8, list.size());
        Assert.assertEquals(16, list.getRealSize());

        Assert.assertEquals(30, list.remove(0).intValue());
        Assert.assertEquals(7, list.size());
        Assert.assertEquals(16, list.getRealSize());

        Assert.assertEquals(40, list.remove(0).intValue());
        Assert.assertEquals(6, list.size());
        Assert.assertEquals(16, list.getRealSize());

        Assert.assertEquals(50, list.remove(0).intValue());
        Assert.assertEquals(5, list.size());
        Assert.assertEquals(10, list.getRealSize());

        Assert.assertEquals(60, list.remove(0).intValue());
        Assert.assertEquals(4, list.size());
        Assert.assertEquals(10, list.getRealSize());

        Assert.assertEquals(70, list.remove(0).intValue());
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(6, list.getRealSize());

        Assert.assertEquals(80, list.remove(0).intValue());
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(4, list.getRealSize());

        Assert.assertEquals(90, list.remove(0).intValue());
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(2, list.getRealSize());

        Assert.assertEquals(100, list.remove(0).intValue());
        Assert.assertEquals(0, list.size());
        Assert.assertEquals(2, list.getRealSize());
    }

    @Test
    public void testClear() {
        CCPArrayList<Integer> list = new CCPArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i * 10);
        }
        list.clear();
        Assert.assertEquals(0, list.size());
        Assert.assertEquals(4, list.getRealSize());
    }

    @Test
    public void testGet() {
        CCPArrayList<Integer> list = new CCPArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i * 10 + 10);
            Assert.assertEquals(i * 10 + 10, list.get(i).intValue());
        }
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
    }

    @Test
    public void testEmpty() {
        CCPArrayList<Integer> list = new CCPArrayList<Integer>();
        Assert.assertTrue(list.isEmpty());
        list.add(10);
        Assert.assertFalse(list.isEmpty());
        list.remove(0);
        Assert.assertTrue(list.isEmpty());
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Assert.assertFalse(list.isEmpty());
        list.clear();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveValues() {
        CCPArrayList<Integer> list = new CCPArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i * 10 + 10);
        }
        Assert.assertEquals(10, list.remove(0).intValue());
        Assert.assertEquals(100, list.remove(8).intValue());
        Assert.assertEquals(50, list.remove(3).intValue());
        Assert.assertEquals(7, list.size());
        Assert.assertEquals(20, list.get(0).intValue());
        Assert.assertEquals(30, list.get(1).intValue());
        Assert.assertEquals(40, list.get(2).intValue());
        Assert.assertEquals(60, list.get(3).intValue());
        Assert.assertEquals(70, list.get(4).intValue());
        Assert.assertEquals(80, list.get(5).intValue());
        Assert.assertEquals(90, list.get(6).intValue());
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.get(7));
    }

    @Test
    public void testSet() {
        CCPArrayList<Integer> list = new CCPArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i * 10 + 10);
        }
        Assert.assertEquals(10, list.set(0, 200).intValue());
        Assert.assertEquals(200, list.get(0).intValue());
        Assert.assertEquals(100, list.set(9, 300).intValue());
        Assert.assertEquals(300, list.get(9).intValue());
        Assert.assertEquals(50, list.set(4, 400).intValue());
    }
}
