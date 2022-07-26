package lazyboywu.leetcode.problems.p0900_p1000.p919CompleteBinaryTreeInserter;

import com.fasterxml.jackson.core.type.TypeReference;
import lazyboywu.leetcode.problems.BaseSolutionTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class CBTInserterTest extends BaseSolutionTest {

    protected void doTest(CBTInserter cbtInserter, List<String> lines) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        // print(root);
        cbtInserter = new CBTInserter(root);
        cbtInserter.insert(3);
        cbtInserter.insert(4);
        root = cbtInserter.get_root();
        print(root);
    }

    protected void print(TreeNode root) {
        TreeNode cur = root;
        int index = 1;

        while (cur != null) {
            System.out.println(cur.val);
            index++;

            // BitOperator
            // int 32bit max 31
            int highBit = 31 - Integer.numberOfLeadingZeros(index);
            // highBit = root
            cur = root;
            for (int i = highBit - 1; i >= 0; i--) {
                if ((index & (1 << i)) == 0) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }

            // BinaryString
            // String indexBits = Integer.toBinaryString(index);
            // cur = root;
            // for (int i = 1; i < indexBits.length(); i++) {
            //     char indexBit = indexBits.charAt(i);
            //     if(indexBit == '0') {
            //         cur = cur.left;
            //     } else {
            //         cur = cur.right;
            //     }
            // }
        }
    }

    @Test
    public void test() throws Exception {
        List<String> lines = null;
        CBTInserter cbtInserter = null;
        doTest(cbtInserter, lines);
    }

}