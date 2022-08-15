package lazyboywu.leetcode.problems.p0600_p0700.p0641DesignCircularDeque;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class MyCircularDeque {
    int k;
    class Node {
        int value;
        Node pre;
        Node last;

        public Node(int value) {
            this.value = value;
        }
    }
    int l = 0;

    Node front;
    Node rear;

    public MyCircularDeque(int k) {
        this.k = k;
    }

    public boolean insertFront(int value) {
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
            node.last = front;
            front.pre = node;
            front = node;
            l += 1;
            return true;
        }
    }

    public boolean insertLast(int value) {
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
            node.pre = rear;
            rear.last = node;
            rear = node;
            l += 1;
            return true;
        }
    }

    public boolean deleteFront() {
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

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        if (l == 1) {
            front = null;
            rear = null;
            l = 0;
            return true;
        }

        rear = rear.pre;
        l -= 1;
        return true;
    }

    public int getFront() {
        return front != null ? front.value : -1;
    }

    public int getRear() {
        return rear != null ? rear.value : -1;
    }

    public boolean isEmpty() {
        return l == 0;
    }

    public boolean isFull() {
        return l == k;
    }
}
