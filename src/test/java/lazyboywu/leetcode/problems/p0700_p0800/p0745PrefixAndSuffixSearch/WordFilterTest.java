package lazyboywu.leetcode.problems.p0700_p0800.p0745PrefixAndSuffixSearch;

import com.fasterxml.jackson.core.type.TypeReference;
import lazyboywu.leetcode.problems.BaseSolutionTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class WordFilterTest extends BaseSolutionTest {

    static final int lineNum = 3;

    protected void doTest(WordFilter wordFilter, List<String> lines) throws Exception {

        String[] commands = parse(lines.get(0), new TypeReference<String[]>() {});
        Object[] params = parse(lines.get(1), new TypeReference<Object[]>() {});
        Object[] expecteds = parse(lines.get(2), new TypeReference<Object[]>() {});

        Object[] actuals = new Object[expecteds.length];

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];


            if (command.equals("WordFilter")) {
                List<List<String>> param = (List<List<String>>)params[i];
                System.out.println("run commands " + command + " " + param.get(0));
                wordFilter = new WordFilter(param.get(0).toArray(new String[]{}));
                actuals[i] = null;
            } else if (command.equals("f")) {
                List<String> param = (List<String>)params[i];
                System.out.println("run commands " + command + " " + param.toString());
                if (wordFilter != null) {
                    actuals[i] = wordFilter.f(param.get(0), param.get(1));
                } else {
                    actuals[i] = false;
                }
                System.out.println("actual " + actuals[i]);
            }


        }

        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testOnce() throws Exception {
        List<String> lines = readLines(lineNum);
        WordFilter wordFilter = null;
        doTest(wordFilter, lines);
    }

    @Test
    public void testAll() throws Exception {
        WordFilter wordFilter = null;
        while (true) {
            List<String> lines = readLines(lineNum);
            if (lines.size() != lineNum) {
                break;
            }
            lines.forEach(System.out::println);
            System.out.println("\n--------------------------------------\n");
            doTest(wordFilter, lines);
        }
    }
}