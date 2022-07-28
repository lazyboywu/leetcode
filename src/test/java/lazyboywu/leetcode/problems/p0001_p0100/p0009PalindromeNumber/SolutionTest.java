package lazyboywu.leetcode.problems.p0001_p0100.p0009PalindromeNumber;

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

    static final int lineNum = 2;

    protected void doTest(Solution solution, List<String> lines) throws Exception {

        Integer num = parse(lines.get(0), new TypeReference<Integer>() {});
        Boolean expected = parse(lines.get(1), new TypeReference<Boolean>() {});

        Boolean actual = solution.isPalindrome(num);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int x = 10001;
        assertEquals(1, solution.get10Bit(10001, 0));
        assertEquals(0, solution.get10Bit(10001, 1));
        assertEquals(0, solution.get10Bit(10001, 2));
        assertEquals(0, solution.get10Bit(10001, 3));
        assertEquals(1, solution.get10Bit(10001, 4));

        assertEquals(1, solution.get10Bit(121, 2));
    }

    @Test
    public void testOnce() throws Exception {
        List<String> lines = readLines(lineNum);
        if (lines.size() < lineNum) {
            throw new Exception("testcase error");
        }
        lines.forEach(System.out::println);
        Solution solution = new Solution();
        doTest(solution, lines);
    }

    @Test
    public void testAll() throws Exception {
        Solution solution = new Solution();
        while (true) {
            List<String> lines = readLines(lineNum);
            if (lines.size() != lineNum) {
                break;
            }
            lines.forEach(System.out::println);
            doTest(solution, lines);
            System.out.println("\n--------------------------------------\n");
        }
    }
}