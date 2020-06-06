
/**
 *
 * @author cuong.hq1
 */
public class QueueArray {

    private int capacity;
    private int[] queue;

    // Indicate front indicator of queue, alway point at non-value index,
    // next index of front indicator will be the front value of queue.
    private int front;

    // Indicate rear (tail) of queue.
    private int rear;

    /**
     * Initialize queue with the current capacity of the queue to be k. **
     * Instead of initialize queue with capacity of k, add a extra element in
     * queue array to prevent confuse situation when rear indicator and front
     * one at a same position, this will bring.
     *
     */
    public void init(int capacity) {
        this.capacity = capacity + 1;
        queue = new int[capacity];
        front = 0;
        rear = 0;
    }

    public QueueArray(int capacity) {
        this.init(capacity);
    }

    /**
     * Insert an element into the circular queue. Return true if the operation
     * is successful.
     *
     * Example with capacity = 4;
     *
     * [INIT]
     *
     * [ ] [ ] [ ] [ ] [ ]
     * | |
     * F R
     *
     * [ENQUEUE X]
     *
     * [ ] [X] [ ] [ ] [ ] | | F R
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation
     * is successful.
     *
     * EXAMPLE: [a] [ ] [b] [x] [y] | | R F
     *
     * [DEQUEUE] [a] [ ] [ ] [x] [y] | | R F
     *
     */
    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int front() {
        if (isEmpty()) {
            return -1;
        }
        result(queue[(front + 1) % capacity] + "");

        return queue[(front + 1) % capacity];
    }

    /**
     * Get the last item from the queue.
     */
    public int rear() {
        if (isEmpty()) {
            return -1;
        }
        result(queue[rear] + "");

        return queue[rear];
    }

    /**
     * Checks whether the circular queue is empty or not.
     *
     * Some examples:
     *
     * [ ] [ ] [ ] [ ] [ ]
     * | |
     * F R
     *
     * F = 0; R = 0 -> EMPTY
     *
     * [ ] [a] [b] [x] [y] | | F R
     *
     * R = 4; F = 0 -> !EMPTY
     */
    public boolean isEmpty() {
        result(front == rear);
        return front == rear;
    }

    /**
     * Checks whether the circular queue is full or not.
     *
     * Some examples: [ ] [a] [b] [x] [y] | | F R
     *
     * R = 4; F = 0 -> FULL
     *
     *
     * [a] [b] [ ] [x] [y] | | R F
     *
     * R = 1; F = 2 -> FULL
     *
     * [a] [b] [ ] [ ] [y] | | R F
     *
     * R = 1; F = 3 -> !FULL
     */
    public boolean isFull() {
        return ((rear + 1) % capacity) == front;
    }

    public void displayQueue() {
        int tmpFront = front;
        int tmpRear = rear;

        if (isEmpty()) {
            System.out.println("Queue: empty");
        } else {
            System.out.print("Queue: ");

            while (tmpFront != tmpRear) {
                tmpFront = (tmpFront + 1) % capacity;
                System.out.print(queue[tmpFront] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Log the result of caller function
     * @param result: display result
     */
    private void result(Object result) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String functionCaller = stackTraceElements[2].getMethodName();

        System.out.print(functionCaller + ": ");

        if (result instanceof Boolean) {
            System.out.println((Boolean) result == true ? "true" : "false");
        } else if (result instanceof String) {
            System.out.println(result.toString());
        }
    }

//    public static void main(String[] args) {
//        ArrayCircularQueue mQueue = new ArrayCircularQueue(5);
//        mQueue.displayQueue();
//        mQueue.enQueue(4);
//        mQueue.displayQueue();
//        mQueue.enQueue(5);
//        mQueue.displayQueue();
//        mQueue.enQueue(6);
//        mQueue.displayQueue();
//        mQueue.enQueue(7);
//        mQueue.displayQueue();
//        mQueue.isEmpty();
//        mQueue.front();
//        mQueue.rear();
//    }
}
