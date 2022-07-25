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

    static final int lineNum = 3;

    // protected void doTest(CBTInserter cbtInserter, List<String> lines) throws Exception {
    //
    //     String[] commands = parse(lines.get(0), new TypeReference<String[]>() {});
    //     Object[] params = parse(lines.get(1), new TypeReference<Object[]>() {});
    //     Object[] expecteds = parse(lines.get(2), new TypeReference<Object[]>() {});
    //
    //     Object[] actuals = new Object[expecteds.length];
    //
    //     for (int i = 0; i < commands.length; i++) {
    //         String command = commands[i];
    //
    //
    //         if (command.equals("CBTInserter")) {
    //             List<List<Integer>> param = (List<List<Integer>>)params[i];
    //             System.out.println("run commands " + command + " " + param.get(0));
    //
    //             cbtInserter = new CBTInserter(param.get(0).toArray(new String[]{}));
    //             actuals[i] = null;
    //         } else if (command.equals("insert")) {
    //             List<Integer> param = (List<Integer>)params[i];
    //             System.out.println("run commands " + command + " " + param.toString());
    //             if (cbtInserter != null) {
    //                 actuals[i] = cbtInserter.insert(param.get(0));
    //             } else {
    //                 actuals[i] = 0;
    //             }
    //             System.out.println("insert " + actuals[i]);
    //         } else if (command.equals("get_root")) {
    //             List<String> param = (List<String>)params[i];
    //             System.out.println("run commands " + command + " " + param.toString());
    //             if (cbtInserter != null) {
    //                 actuals[i] = cbtInserter.get_root();
    //             } else {
    //                 actuals[i] = new int[0];
    //             }
    //             System.out.println("get_root " + actuals[i]);
    //         }
    //
    //
    //     }
    //
    //     Assert.assertArrayEquals(expecteds, actuals);
    // }

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

            String indexBits = Integer.toBinaryString(index);
            cur = root;
            for (int i = 1; i < indexBits.length(); i++) {
                char indexBit = indexBits.charAt(i);
                if(indexBit == '0') {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
        }
    }

    @Test
    public void test() throws Exception {
        List<String> lines = null;
        CBTInserter cbtInserter = null;
        doTest(cbtInserter, lines);
    }

    @Test
    public void testOnce() throws Exception {
        List<String> lines = readLines(lineNum);
        CBTInserter cbtInserter = null;
        doTest(cbtInserter, lines);
    }

    @Test
    public void testAll() throws Exception {
        CBTInserter cbtInserter = null;
        while (true) {
            List<String> lines = readLines(lineNum);
            if (lines.size() != lineNum) {
                break;
            }
            lines.forEach(System.out::println);
            System.out.println("\n--------------------------------------\n");
            doTest(cbtInserter, lines);
        }
    }
}