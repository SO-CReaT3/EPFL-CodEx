package cs108;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundedIntQueueOkTest {

    @Test
    void BoundedIntQueueNegativeCapacityIllegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIntQueueBuggy(-1);
        });
    }

    @Test
    void capacity() {
        BoundedIntQueueOk queue = new BoundedIntQueueOk(10);
        assertEquals(10, queue.capacity());
    }

    @Test
    void size() {
        BoundedIntQueueOk queue = new BoundedIntQueueOk(10);
        assertEquals(0, queue.size());
    }

    @Test
    void isEmpty() {
        BoundedIntQueueOk queue = new BoundedIntQueueOk(0);
        assertTrue(queue.isEmpty());
    }

    @Test
    void isFull() {
        BoundedIntQueueOk queue = new BoundedIntQueueOk(3);
        assertFalse(queue.isFull());

        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        assertTrue(queue.isFull());
    }

    @Test
    void addLast() {
        BoundedIntQueueOk queue = new BoundedIntQueueOk(2);
        queue.addLast(1);
        queue.addLast(2);

        assertThrows(java.lang.IllegalStateException.class, () -> {
            queue.addLast(3);
        });
    }

    @Test
    void removeFirst() {
        assertThrows(java.lang.IllegalStateException.class, () -> {
            BoundedIntQueueOk queue = new BoundedIntQueueOk(2);
            queue.removeFirst();
        });
    }
}