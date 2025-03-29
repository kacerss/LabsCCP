
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CCPALQTests {
    @Test
    public void testSetup() {
        CCPQueue<Integer> q = new CCPALQ<Integer>();
        Assertions.assertEquals(0, q.size());
    }

    @Test
    public void testEnqueueSize() {
        CCPQueue<Integer> q = new CCPALQ<Integer>();
        Assertions.assertTrue(q.enqueue(0));
        Assertions.assertTrue(q.enqueue(10));
        Assertions.assertTrue(q.enqueue(20));
        Assertions.assertTrue(q.enqueue(30));
        Assertions.assertTrue(q.enqueue(40));
        Assertions.assertTrue(q.enqueue(50));
        Assertions.assertTrue(q.enqueue(60));
        Assertions.assertTrue(q.enqueue(70));
        Assertions.assertTrue(q.enqueue(80));
        Assertions.assertTrue(q.enqueue(90));
        Assertions.assertEquals(10, q.size());
    }

    @Test
    public void testDequeueSize() {
        CCPQueue<Integer> q = new CCPALQ<Integer>();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }
        Assertions.assertEquals(10, q.size());
        for (int i = 0; i < 10; i++) {
            Assertions.assertEquals(10 - i, q.size());
            Assertions.assertEquals(i, q.dequeue().intValue());
        }
        Assertions.assertEquals(0, q.size());
        Assertions.assertThrows(NoSuchElementException.class, () -> q.dequeue());
    }

    @Test
    public void testPeek() {
        CCPQueue<Integer> q = new CCPALQ<Integer>();
        Assertions.assertNull(q.peek());
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
            Assertions.assertEquals(0, q.peek().intValue());
        }

        // Check that repeating peek operations do not change the value or size.
        for (int i = 0; i < 5; i++) {
            Assertions.assertEquals(0, q.peek().intValue());
            Assertions.assertEquals(10, q.size());
        }

        for (int i = 0; i < 10; i++) {
            Assertions.assertEquals(i, q.peek().intValue());
            q.dequeue();
        }
        Assertions.assertNull(q.peek());
    }

    @Test
    public void testManyElements() {
        CCPQueue<Integer> q = new CCPALQ<Integer>();
        for (int i = 0; i < 1_000_000; i++) {
            Assertions.assertTrue(q.enqueue(i));
            Assertions.assertEquals(i + 1, q.size());

        }

        Assertions.assertEquals(1_000_000, q.size());

        for (int i = 0; i < 1_000_000; i++) {
            Assertions.assertEquals(1_000_000 - i, q.size());
            Assertions.assertEquals(i, q.dequeue().intValue());
        }
        Assertions.assertEquals(0, q.size());
        Assertions.assertThrows(NoSuchElementException.class, () -> q.dequeue());

    }

    @Test
    public void testCombineSimilarQueues() {
        CCPQueue<Integer> q1 = new CCPALQ<Integer>();
        CCPQueue<Integer> q2 = new CCPALQ<Integer>();

        for (int i = 0; i < 10; i++) {
            q1.enqueue(i);
            q2.enqueue(i + 10);
        }

        q1.combine(q2);
        Assertions.assertEquals(0, q2.size());

        Assertions.assertEquals(20, q1.size());

        for (int i = 0; i < 20; i++) {
            Assertions.assertEquals(20 - i, q1.size());
            Assertions.assertEquals(i, q1.peek().intValue());
            Assertions.assertEquals(i, q1.dequeue().intValue());
        }
        Assertions.assertEquals(0, q1.size());
        Assertions.assertThrows(NoSuchElementException.class, () -> q1.dequeue());
    }

    @Test
    public void testCombineDifferentQueues() {
        CCPQueue<Integer> q1 = new CCPALQ<Integer>();
        CCPQueue<Integer> q2 = new CCPLLQ<Integer>();

        for (int i = 0; i < 10; i++) {
            q1.enqueue(i);
            q2.enqueue(i + 10);
        }

        q1.combine(q2);
        Assertions.assertEquals(0, q2.size());

        Assertions.assertEquals(20, q1.size());

        for (int i = 0; i < 20; i++) {
            Assertions.assertEquals(20 - i, q1.size());
            Assertions.assertEquals(i, q1.peek().intValue());
            Assertions.assertEquals(i, q1.dequeue().intValue());
        }
        Assertions.assertEquals(0, q1.size());
        Assertions.assertThrows(NoSuchElementException.class, () -> q1.dequeue());
    }

}
