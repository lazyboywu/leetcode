package lazyboywu.leetcode.problems.p1300_p1400.p1331RankTransformOfAnArray;

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

        int[] expression = parse(lines.get(0), new TypeReference<int[]>() {});
        int[] expected = parse(lines.get(1), new TypeReference<int[]>() {});

        int[] actual = solution.arrayRankTransform(expression);
        System.out.println(Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }
}