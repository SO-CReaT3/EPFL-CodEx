package cs108;

public class BoundedIntQueueOk implements BoundedIntQueue {
    private int[] queue;
    private final int CAPACITY;
    private int currentSize;

    public BoundedIntQueueOk(int capacity) {
        CAPACITY = capacity;
        try {
            if (capacity < 0) {
                throw new IllegalArgumentException("Capacity must be a positive integer");
            } else {
                queue = new int[capacity];
                currentSize = 0;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int capacity() {
        return CAPACITY;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean isFull() {
        return currentSize == CAPACITY;
    }

    @Override
    public void addLast(int newElement) {
        try {
            if (currentSize == CAPACITY) {
                throw new IllegalStateException("Queue is full");
            } else {
                queue[currentSize] = newElement;
                currentSize++;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception _) {

        }
    }

    @Override
    public int removeFirst() {
        try {
            if (currentSize == 0) {
                throw new IllegalStateException("Queue is empty");
            } else {
                int firstElement = queue[0];
                System.arraycopy(queue, 1, queue, 0, currentSize);
                currentSize--;
                return firstElement;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception _) {

        }
        return 0;
    }
}
