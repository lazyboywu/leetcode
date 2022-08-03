package lazyboywu.leetcode.problems.p0600_p0700.p0622DesignCircularQueue;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class MyCircularQueue {

    int k;
    class Node {
        int value;
        Node last;

        public Node(int value) {
            this.value = value;
        }
    }
    int l = 0;

    Node front;
    Node rear;

    public MyCircularQueue(int k) {
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            Node node = new Node(value);
            front = node;
            rear = node;
            l += 1;
            return true;
        } else {
            Node node = new Node(value);
            rear.last = node;
            rear = node;
            l += 1;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (l == 1) {
            front = null;
            rear = null;
            l = 0;
            return true;
        }

        front = front.last;
        l -= 1;
        return true;
    }

    public int Front() {
        return front != null ? front.value : -1;
    }

    public int Rear() {
        return rear != null ? rear.value : -1;
    }

    public boolean isEmpty() {
        return l == 0;
    }

    public boolean isFull() {
        return l == k;
    }
}
