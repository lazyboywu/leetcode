package lazyboywu.leetcode.problems.p1200_p1300.p1206DesignSkiplist;

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
public class SkiplistTest extends BaseSolutionTest {

    static final int lineNum = 3;

    protected void doTest(Skiplist skiplist, List<String> lines) throws Exception {

        String[] commands = parse(lines.get(0), new TypeReference<String[]>() {});
        Object[] params = parse(lines.get(1), new TypeReference<Object[]>() {});
        Object[] expecteds = parse(lines.get(2), new TypeReference<Object[]>() {});

        Object[] actuals = new Object[expecteds.length];

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            StringBuffer printBuffer = new StringBuffer();
            printBuffer.append("run commands ").append(command);
            if (command.equals("Skiplist")) {
                skiplist = new Skiplist();
                actuals[i] = null;
            } else if (command.equals("add")) {
                List<Integer> param = (List<Integer>)params[i];
                printBuffer.append("  ").append("param ").append(param);
                if (skiplist != null) {
                    skiplist.add(param.get(0));
                }
                actuals[i] = null;
            } else if (command.equals("search")) {
                List<Integer> param = (List<Integer>)params[i];
                printBuffer.append("  ").append("param ").append(param);
                if (skiplist != null) {
                    actuals[i] = skiplist.search(param.get(0));
                } else {
                    actuals[i] = false;
                }
            } else if (command.equals("erase")) {
                List<Integer> param = (List<Integer>)params[i];
                printBuffer.append("  ").append("param ").append(param);
                if (skiplist != null) {
                    actuals[i] = skiplist.erase(param.get(0));
                } else {
                    actuals[i] = false;
                }
            }
            printBuffer.append("  ").append("=  ").append(actuals[i]);
            System.out.println(printBuffer);
        }

        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test() throws Exception {
        Skiplist skiplist = new Skiplist();

        skiplist.add(5);
        skiplist.add(1);

        print(skiplist);

        Assert.assertTrue(skiplist.search(5));

        Assert.assertTrue(skiplist.erase(5));

        print(skiplist);

        Assert.assertFalse(skiplist.search(5));
    }

    protected void print(Skiplist skiplist) {
        for (int i = skiplist.level; i >= Skiplist.MinLevel; i--) {
            Skiplist.ListNode cur = skiplist.header;
            while (cur != null) {
                System.out.print(cur.key + " - ");
                cur = cur.forward[i];
            }
            System.out.println();
        }
    }

    @Test
    public void testOnce() throws Exception {
        List<String> lines = readLines(lineNum);
        Skiplist skiplist = null;
        doTest(skiplist, lines);
    }

    @Test
    public void testAll() throws Exception {
        Skiplist skiplist = null;
        while (true) {
            List<String> lines = readLines(lineNum);
            if (lines.size() != lineNum) {
                break;
            }
            lines.forEach(System.out::println);
            System.out.println("\n--------------------------------------\n");
            doTest(skiplist, lines);
        }
    }
}