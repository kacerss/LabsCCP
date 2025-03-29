import org.junit.Test;
import org.junit.Assert;

public class CCPLinkedListTests {
    @Test
    public void testSetup() {
        CCPLinkedList<Integer> list = new CCPLinkedList<Integer>();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testAdd() {
        CCPLinkedList<Integer> list = new CCPLinkedList<Integer>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
        int value = 0;
        for (Integer i : list) {
            Assert.assertEquals(value, i.intValue());
            value += 10;
        }
    }

    @Test
    public void testEmpty() {
        CCPLinkedList<Integer> list = new CCPLinkedList<Integer>();
        Assert.assertTrue(list.isEmpty());
        list.add(10);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void testEmptyAfterClear() {
        CCPLinkedList<Integer> list = new CCPLinkedList<Integer>();
        Assert.assertTrue(list.isEmpty());
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Assert.assertFalse(list.isEmpty());
        list.clear();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testEmptyAfterRemove() {
        CCPLinkedList<Integer> list = new CCPLinkedList<Integer>();
        Assert.assertTrue(list.isEmpty());
        list.add(10);
        Assert.assertFalse(list.isEmpty());
        list.remove();
        Assert.assertTrue(list.isEmpty());
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Assert.assertFalse(list.isEmpty());
        for (int i = 0; i < 10; i++) {
            list.remove();
        }
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testAddAtPosition() {
        CCPLinkedList<Integer> list = new CCPLinkedList<Integer>();
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
        CCPLinkedList<Integer> list = new CCPLinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            list.add(i * 10);
        }
        Assert.assertEquals(10, list.size());
        Assert.assertEquals(10, list.remove(0).intValue());
        Assert.assertEquals(9, list.size());
        Assert.assertEquals(20, list.remove(0).intValue());
        Assert.assertEquals(8, list.size());

        for (int i = 0; i < 8; i++) {
            Assert.assertEquals(30 + i * 10, list.remove(0).intValue());
            Assert.assertEquals(7 - i, list.size());
        }
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    public void testClear() {
        CCPLinkedList<Integer> list = new CCPLinkedList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i * 10);
        }
        list.clear();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testGet() {
        CCPLinkedList<Integer> list = new CCPLinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i * 10 + 10);
            Assert.assertEquals(i * 10 + 10, list.get(i).intValue());
        }
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
    }

    @Test
    public void testRemoveValues() {
        CCPLinkedList<Integer> list = new CCPLinkedList<Integer>();
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
        CCPLinkedList<Integer> list = new CCPLinkedList<Integer>();
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
