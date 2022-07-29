package lazyboywu.leetcode.problems.p1200_p1300.p1252OddCells;

import com.fasterxml.jackson.core.type.TypeReference;
import lazyboywu.leetcode.problems.BaseSolutionTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class SolutionTest extends BaseSolutionTest {
    static final int lineNum = 4;

    @Test
    public void test() throws Exception {
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

        int m = parse(lines.get(0), new TypeReference<Integer>() {});
        int n = parse(lines.get(1), new TypeReference<Integer>() {});
        int[][] indices = parse2dIntArray(lines.get(2));
        int expected = parse(lines.get(3), new TypeReference<Integer>() {});

        int actual = solution.oddCells(m, n, indices);

        Assert.assertEquals(expected, actual);
    }
}