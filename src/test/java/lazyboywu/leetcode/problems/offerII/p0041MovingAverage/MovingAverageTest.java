package lazyboywu.leetcode.problems.offerII.p0041MovingAverage;

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
public class MovingAverageTest extends BaseSolutionTest {

    static final int lineNum = 3;

    protected void doTest(MovingAverage movingAverage, List<String> lines) throws Exception {

        String[] commands = parse(lines.get(0), new TypeReference<String[]>() {});
        Object[] params = parse(lines.get(1), new TypeReference<Object[]>() {});
        Double[] expecteds = parse(lines.get(2), new TypeReference<Double[]>() {});

        Double[] actuals = new Double[expecteds.length];

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            if (command.equals("MovingAverage")) {
                List<Integer> param = (List<Integer>)params[i];
                System.out.println("run commands " + command + " " + param.get(0));
                movingAverage = new MovingAverage(param.get(0));
                actuals[i] = null;
            } else if (command.equals("next")) {
                List<Integer> param = (List<Integer>)params[i];
                System.out.println("run commands " + command + " " + param.toString());
                if (movingAverage != null) {
                    actuals[i] = scaleValue(movingAverage.next(param.get(0)));
                } else {
                    actuals[i] = 0.0;
                }
                System.out.println("actual " + actuals[i]);
            }


        }

        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testOnce() throws Exception {
        List<String> lines = readLines(lineNum);
        MovingAverage movingAverage = null;
        doTest(movingAverage, lines);
    }

    @Test
    public void testAll() throws Exception {
        MovingAverage movingAverage = null;
        while (true) {
            List<String> lines = readLines(lineNum);
            if (lines.size() != lineNum) {
                break;
            }
            lines.forEach(System.out::println);
            System.out.println("\n--------------------------------------\n");
            doTest(movingAverage, lines);
        }
    }

    protected double scaleValue(double value) {
        return new BigDecimal(value).setScale(5, RoundingMode.UP.ordinal()).doubleValue();
    }
}