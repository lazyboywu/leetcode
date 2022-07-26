package lazyboywu.leetcode.problems.p1200_p1300.p1206DesignSkiplist;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 * @link https://leetcode.cn/problems/design-skiplist
 */
public class Skiplist {

    static final int MaxLevel = 15;
    static final int MinLevel = 0;
    static final double P = 0.25;

    class ListNode {
        int key;
        ListNode[] forward = new ListNode[MaxLevel+1];
        int count = 1;

        ListNode() {}

        ListNode(int key) {
            this.key = key;
        }
    }

    ListNode header;
    static final ListNode Nil = null;
    int level = MinLevel;

    public Skiplist() {
        header = new ListNode();
    }

    public boolean search(int target) {
        ListNode cur = header;

        // find num search position
        for (int i = level; i >= MinLevel; i--) {
            while (cur.forward[i] != Nil && cur.forward[i].key < target) {
                cur = cur.forward[i];
            }
        }

        // cur->key < num <= cur->forward[1]->key
        cur = cur.forward[MinLevel];
        return cur != Nil && cur.key == target;
    }

    public void add(int num) {
        ListNode[] update = new ListNode[MaxLevel+1];
        ListNode cur = header;

        // find num insert position
        for (int i = level; i >= MinLevel; i--) {
            while (cur.forward[i] != Nil && cur.forward[i].key < num) {
                cur = cur.forward[i];
            }
            update[i] = cur;
        }

        // cur->key < num <= cur->forward[1]->key
        cur = cur.forward[MinLevel];

        if (cur != Nil && cur.key == num) {
            cur.count += 1;
        } else {
            int newLevel = randomLevel();

            if (newLevel > level) {
                for (int i = level + 1; i <= newLevel; i++) {
                    update[i] = header;
                }
                level = newLevel;
            }
            cur = new ListNode(num);
            for (int i = MinLevel; i <= newLevel; i++) {
                if (update[i].forward[i] != Nil) {
                    cur.forward[i] = update[i].forward[i];
                }
                update[i].forward[i] = cur;
            }
        }
    }

    public boolean erase(int num) {
        ListNode[] update = new ListNode[MaxLevel+1];
        ListNode cur = header;

        // find num erase position
        for (int i = level; i >= MinLevel; i--) {
            while (cur.forward[i] != Nil && cur.forward[i].key < num) {
                cur = cur.forward[i];
            }
            update[i] = cur;
        }

        // cur->key < num <= cur->forward[1]->key
        cur = cur.forward[MinLevel];

        if (cur != Nil && cur.key == num) {
            if (cur.count > 1) {
                cur.count -= 1;
                return true;
            } else {
                for (int i = MinLevel; i <= level; i++) {
                    if (update[i].forward[i] == Nil) {
                        break;
                    }
                    if (update[i].forward[i] != cur) {
                        break;
                    }
                    update[i].forward[i] = cur.forward[i];
                }
                while (level > MinLevel && header.forward[level] == null) {
                    level -= 1;
                }
                return true;
            }
        }
        return false;
    }

    protected int randomLevel() {
        int level = MinLevel;
        while (Math.random() < P) {
            level++;
        }
        return Math.min(level, MaxLevel);
    }
}


