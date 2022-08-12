package lazyboywu.leetcode.problems.p1400_p1500.p1417ReformatString;

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

        String s = "a0b1c2d";

        String[] sSplited = solution.split(s);

        System.out.println(Arrays.toString(sSplited));

        String ans = solution.merge(sSplited[Solution.DIGIT], sSplited[Solution.CHAR]);

        System.out.println(ans);
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

        String s = parse(lines.get(0), new TypeReference<String>() {});
        String expected = parse(lines.get(1), new TypeReference<String>() {});

        String actual = solution.reformat(s);

        System.out.println(actual);
        // Assert.assertEquals(expected, actual);
    }
}