package lazyboywu.leetcode.problems.p0001_p0100.p0001TwoSum;

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

    static final int lineNum = 3;

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

        int[] nums = parse(lines.get(0), new TypeReference<int[]>() {});
        int target = parse(lines.get(1), new TypeReference<Integer>() {});
        int[] expected = parse(lines.get(2), new TypeReference<int[]>() {});

        int[] actual = solution.twoSum(nums, target);

        Assert.assertArrayEquals(expected, actual);
    }
}
