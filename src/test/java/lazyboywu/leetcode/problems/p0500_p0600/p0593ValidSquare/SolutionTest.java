package lazyboywu.leetcode.problems.p0500_p0600.p0593ValidSquare;

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
public class SolutionTest extends BaseSolutionTest {

    static final int lineNum = 5;

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

        int[] p1 = parse(lines.get(0), new TypeReference<int[]>() {});
        int[] p2 = parse(lines.get(1), new TypeReference<int[]>() {});
        int[] p3 = parse(lines.get(2), new TypeReference<int[]>() {});
        int[] p4 = parse(lines.get(3), new TypeReference<int[]>() {});
        Boolean expected = parse(lines.get(4), new TypeReference<Boolean>() {});

        Boolean actual = solution.validSquare(p1, p2, p3, p4);

        Assert.assertEquals(expected, actual);
    }
}