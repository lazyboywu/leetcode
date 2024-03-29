package lazyboywu.leetcode.problems.p0900_p1000.p919CompleteBinaryTreeInserter;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class CBTInserter {

    int treeIndex = 0;
    TreeNode root;


    public CBTInserter(TreeNode root) {
        this.root = root;
        TreeNode cur;
        // 遍历树，计算index的定位
        do  {
            treeIndex++;

            int highBit = 31 - Integer.numberOfLeadingZeros(treeIndex);
            // root 永远在第一位
            cur = root;

            for (int i = highBit - 1; i >= 0; i--) {
                if ((treeIndex & (1 << i)) == 0) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
        } while (cur != null);
    }

    public int insert(int val) {
        //基于index找到插入的父节点
        int insertIndex = treeIndex + 1;
        TreeNode parent;

        int highBit = 31 - Integer.numberOfLeadingZeros(treeIndex);
        // root 永远在第一位
        parent = root;

        for (int i = highBit - 1; i >= 1; i--) {
            if ((treeIndex & (1 << i)) == 0) {
                parent = parent.left;
            } else {
                parent = parent.right;
            }
        }

        if((treeIndex & 1) == 0) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }

        treeIndex = insertIndex;
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
