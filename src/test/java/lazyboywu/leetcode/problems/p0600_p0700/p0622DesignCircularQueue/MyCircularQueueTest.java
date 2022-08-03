package lazyboywu.leetcode.problems.p0600_p0700.p0622DesignCircularQueue;

import com.fasterxml.jackson.core.type.TypeReference;
import lazyboywu.leetcode.problems.BaseSolutionTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class MyCircularQueueTest extends BaseSolutionTest {

    static final int lineNum = 3;

    @Test
    public void test() throws Exception {
    }

    @Test
    public void testOnce() throws Exception {
        MyCircularQueue myCircularQueue = null;
        testOnce(lineNum, myCircularQueue);
    }

    @Test
    public void testAll() throws Exception {
        MyCircularQueue myCircularQueue = null;
        testAll(lineNum, myCircularQueue);
    }

    @Override
    protected <T> void doTest(T instance, List<String> lines) throws Exception {
        doTest((MyCircularQueue)instance, lines);
    }

    protected void doTest(MyCircularQueue myCircularQueue, List<String> lines) throws Exception {

        String[] commands = parse(lines.get(0), new TypeReference<String[]>() {});
        Object[] params = parse(lines.get(1), new TypeReference<Object[]>() {});
        Object[] expecteds = parse(lines.get(2), new TypeReference<Object[]>() {});

        Object[] actuals = new Object[expecteds.length];

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            StringBuffer printBuffer = new StringBuffer();
            printBuffer.append("run commands ").append(command);
            if (command.equals("MyCircularQueue")) {
                List<Integer> param = (List<Integer>)params[i];
                printBuffer.append("  ").append("param ").append(param);
                myCircularQueue = new MyCircularQueue(param.get(0));
                actuals[i] = null;
            } else if (command.equals("enQueue")) {
                List<Integer> param = (List<Integer>)params[i];
                printBuffer.append("  ").append("param ").append(param);
                if (myCircularQueue != null) {
                    actuals[i] = myCircularQueue.enQueue(param.get(0));
                } else {
                    actuals[i] = false;
                }
            } else if (command.equals("Front")) {
                // List<Integer> param = (List<Integer>)params[i];
                // printBuffer.append("  ").append("param ").append(param);
                if (myCircularQueue != null) {
                    actuals[i] = myCircularQueue.Front();
                } else {
                    actuals[i] = false;
                }
            } else if (command.equals("Rear")) {
                // List<Integer> param = (List<Integer>)params[i];
                // printBuffer.append("  ").append("param ").append(param);
                if (myCircularQueue != null) {
                    actuals[i] = myCircularQueue.Rear();
                } else {
                    actuals[i] = false;
                }
            } else if (command.equals("isEmpty")) {
                // List<Integer> param = (List<Integer>)params[i];
                // printBuffer.append("  ").append("param ").append(param);
                if (myCircularQueue != null) {
                    actuals[i] = myCircularQueue.isFull();
                } else {
                    actuals[i] = false;
                }
            } else if (command.equals("isFull")) {
                // List<Integer> param = (List<Integer>)params[i];
                // printBuffer.append("  ").append("param ").append(param);
                if (myCircularQueue != null) {
                    actuals[i] = myCircularQueue.isFull();
                } else {
                    actuals[i] = false;
                }
            } else if (command.equals("deQueue")) {
                // List<Integer> param = (List<Integer>)params[i];
                // printBuffer.append("  ").append("param ").append(param);
                if (myCircularQueue != null) {
                    actuals[i] = myCircularQueue.deQueue();
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