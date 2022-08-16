package lazyboywu.leetcode.problems.p1600_p1700.p1656OrderedStream;

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
public class OrderedStreamTest extends BaseSolutionTest {

    static final int lineNum = 3;

    @Test
    public void test() throws Exception {
    }

    @Test
    public void testOnce() throws Exception {
        OrderedStream orderedStream = null;
        testOnce(lineNum, orderedStream);
    }

    @Test
    public void testAll() throws Exception {
        OrderedStream orderedStream = null;
        testAll(lineNum, orderedStream);
    }

    @Override
    protected <T> void doTest(T instance, List<String> lines) throws Exception {
        doTest((OrderedStream)instance, lines);
    }

    protected void doTest(OrderedStream orderedStream, List<String> lines) throws Exception {

        String[] commands = parse(lines.get(0), new TypeReference<String[]>() {});
        Object[] params = parse(lines.get(1), new TypeReference<Object[]>() {});
        Object[] expecteds = parse(lines.get(2), new TypeReference<Object[]>() {});

        Object[] actuals = new Object[expecteds.length];

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            StringBuffer printBuffer = new StringBuffer();
            printBuffer.append("run commands ").append(command);
            if (command.equals("OrderedStream")) {
                List<Integer> param = (List<Integer>)params[i];
                printBuffer.append("  ").append("param ").append(param);
                orderedStream = new OrderedStream(param.get(0));
                actuals[i] = null;
            } else if (command.equals("insert")) {
                List<Object> param = (List<Object>)params[i];
                printBuffer.append("  ").append("param ").append(param);
                if (orderedStream != null) {
                    actuals[i] = orderedStream.insert((Integer)param.get(0), (String)param.get(1));
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