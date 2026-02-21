package cs108;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BoundedIntQueueTest {

    @Test
    void BoundedIntQueueNegativeCapacityIllegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIntQueueBuggy(-1);
        });
    }

    @Test
    void capacity() {
        BoundedIntQueueBuggy queue = new BoundedIntQueueBuggy(10);
        assertEquals(10, queue.capacity());
    }

    @Test
    void size() {
        BoundedIntQueueBuggy queue = new BoundedIntQueueBuggy(10);
        assertEquals(0, queue.size());
    }

    @Test
    void isEmpty() {
        BoundedIntQueueBuggy queue = new BoundedIntQueueBuggy(0);
        assertTrue(queue.isEmpty());
    }

    @Test
    void isFull() {
        BoundedIntQueueBuggy queue = new BoundedIntQueueBuggy(3);
        assertFalse(queue.isFull());

        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        assertTrue(queue.isFull());
    }

    @Test
    void addLast() {
        assertThrows(java.lang.IllegalStateException.class, () -> {
            BoundedIntQueueBuggy queue = new BoundedIntQueueBuggy(2);
            queue.addLast(1);
            queue.addLast(2);
            queue.addLast(3);
        });
    }

    @Test
    void removeFirst() {
        assertThrows(java.lang.IllegalStateException.class, () -> {
            BoundedIntQueueBuggy queue = new BoundedIntQueueBuggy(2);
            queue.removeFirst();
        });
    }
}