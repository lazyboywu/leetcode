package lazyboywu.leetcode.problems.p0600_p0700.p0641DesignCircularDeque;

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
public class MyCircularDequeTest extends BaseSolutionTest {

    static final int lineNum = 3;

    @Test
    public void test() throws Exception {
    }

    @Test
    public void testOnce() throws Exception {
        MyCircularDeque myCircularDeque = null;
        testOnce(lineNum, myCircularDeque);
    }

    @Test
    public void testAll() throws Exception {
        MyCircularDeque myCircularDeque = null;
        testAll(lineNum, myCircularDeque);
    }

    @Override
    protected <T> void doTest(T instance, List<String> lines) throws Exception {
        doTest((MyCircularDeque)instance, lines);
    }

    protected void doTest(MyCircularDeque myCircularDeque, List<String> lines) throws Exception {

        String[] commands = parse(lines.get(0), new TypeReference<String[]>() {});
        Object[] params = parse(lines.get(1), new TypeReference<Object[]>() {});
        Object[] expecteds = parse(lines.get(2), new TypeReference<Object[]>() {});

        Object[] actuals = new Object[expecteds.length];

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            StringBuffer printBuffer = new StringBuffer();
            printBuffer.append("run commands ").append(command);
            if (command.equals("MyCircularDeque")) {
                List<Integer> param = (List<Integer>)params[i];
                printBuffer.append("  ").append("param ").append(param);
                myCircularDeque = new MyCircularDeque(param.get(0));
                actuals[i] = null;
            } else if (command.equals("insertFront")) {
                List<Integer> param = (List<Integer>)params[i];
                printBuffer.append("  ").append("param ").append(param);
                if (myCircularDeque != null) {
                    actuals[i] = myCircularDeque.insertFront(param.get(0));
                } else {
                    actuals[i] = false;
                }
            } else if (command.equals("insertLast")) {
                List<Integer> param = (List<Integer>)params[i];
                printBuffer.append("  ").append("param ").append(param);
                if (myCircularDeque != null) {
                    actuals[i] = myCircularDeque.insertLast(param.get(0));
                } else {
                    actuals[i] = false;
                }
            } else if (command.equals("deleteFront")) {
                // List<Integer> param = (List<Integer>)params[i];
                // printBuffer.append("  ").append("param ").append(param);
                if (myCircularDeque != null) {
                    actuals[i] = myCircularDeque.deleteFront();
                } else {
                    actuals[i] = false;
                }
            } else if (command.equals("deleteLast")) {
                // List<Integer> param = (List<Integer>)params[i];
                // printBuffer.append("  ").append("param ").append(param);
                if (myCircularDeque != null) {
                    actuals[i] = myCircularDeque.deleteLast();
                } else {
                    actuals[i] = false;
                }
            } else if (command.equals("getFront")) {
                // List<Integer> param = (List<Integer>)params[i];
                // printBuffer.append("  ").append("param ").append(param);
                if (myCircularDeque != null) {
                    actuals[i] = myCircularDeque.getFront();
                } else {
                    actuals[i] = 0;
                }
            } else if (command.equals("getRear")) {
                // List<Integer> param = (List<Integer>)params[i];
                // printBuffer.append("  ").append("param ").append(param);
                if (myCircularDeque != null) {
                    actuals[i] = myCircularDeque.getRear();
                } else {
                    actuals[i] = 0;
                }
            } else if (command.equals("isEmpty")) {
                // List<Integer> param = (List<Integer>)params[i];
                // printBuffer.append("  ").append("param ").append(param);
                if (myCircularDeque != null) {
                    actuals[i] = myCircularDeque.isFull();
                } else {
                    actuals[i] = false;
                }
            } else if (command.equals("isFull")) {
                // List<Integer> param = (List<Integer>)params[i];
                // printBuffer.append("  ").append("param ").append(param);
                if (myCircularDeque != null) {
                    actuals[i] = myCircularDeque.isFull();
                } else {
                    actuals[i] = false;
                }
            }
            printBuffer.append("  ").append("=  ").append(actuals[i]);
            System.out.println(printBuffer);
        }

        Assert.assertArrayEquals(expecteds, actuals);
    }
}