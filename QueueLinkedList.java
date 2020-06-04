
/**
 *
 * @author cuong.hq1
 */
public class QueueLinkedList {
    
    private Item front;
    private Item rear;
    
    private int size;
    
    QueueLinkedList() {
        init();
    }
    
    public void init() {
        front = new Item(-1);
        rear = front;
    }
    
    public boolean isEmpty() {
        return rear.next == null;
    }
    
    public int size() {
        return size;
    }
    
    public int dequeue() {
        if (isEmpty())
            return -1;
        
        Item item = rear.next;
        rear.next = item.next;
        
        if (rear.next == null) {
            front = rear;
        }
        
        size -= 1;
        return item.val;
    }
    
    public void enqueue(int val) {
        Item item = new Item(val);
        front.next = item;
        front = item;
        
        if (rear.next == null) {
            rear.next = front;
        }
        
        size += 1;
    }
    
    public int peek() {
        if (size() == 0)
            return -1;
        
        return rear.val;
    }

    @Override
    public String toString() {
        String result = "Empty";
        if (!isEmpty()) {
            result = "";
            Item tmp = rear.next;
            while (tmp != null) {
                result = result.concat(tmp + " ");
                tmp = tmp.next;
            }
        }
        return result;
    }
    
    
    class Item {
        int val;
        Item next;
        
        Item(int val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return val + "";
        }
        
        
    }
    
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        System.out.println(queue);
        queue.enqueue(3);
        System.out.println(queue);
        queue.enqueue(5);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        queue.enqueue(6);
        System.out.println(queue);
        queue.enqueue(8);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
