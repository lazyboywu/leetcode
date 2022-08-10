package lazyboywu.leetcode.problems.p0600_p0700.p0640SolveEquation;

import com.fasterxml.jackson.core.type.TypeReference;
import lazyboywu.leetcode.problems.BaseSolutionTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class SolutionTest extends BaseSolutionTest {
    static final int lineNum = 2;

    @Test
    public void test() throws Exception {

        Solution solution = new Solution();

        String expression = "6+x-2";

        System.out.println(Arrays.toString(solution.simplifyExpression(expression)));
    }

    @Test
    public void testOnce() throws Exception {
        Solution solution = new Solution();
        testOnce(lineNum, solution);
    }

    @Test
    public void testAll() throws Exception {
        Solution solution = new Solution();
        testAll(lineNum, solution);
    }

    @Override
    protected <T> void doTest(T instance, List<String> lines) throws Exception {
        doTest((Solution)instance, lines);
    }

    protected void doTest(Solution solution, List<String> lines) throws Exception {

        String equation = parse(lines.get(0), new TypeReference<String>() {});
        String expected = parse(lines.get(1), new TypeReference<String>() {});

        String actual = solution.solveEquation(equation);

        Assert.assertEquals(expected, actual);
    }
}