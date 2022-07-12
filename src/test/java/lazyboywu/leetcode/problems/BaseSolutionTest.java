package lazyboywu.leetcode.problems;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class BaseSolutionTest {
    public BufferedReader reader;
    ObjectMapper mapper = new ObjectMapper();
    public BaseSolutionTest() {
        reader = new BufferedReader((
                new InputStreamReader(this.getClass().getResourceAsStream("testcase.txt"))
        ));
    }

    public List<String> readLines(int lineNum) throws Exception {
        List<String> lines = new ArrayList<>();
        while (lineNum > 0 && reader.ready()) {
            lines.add(reader.readLine());
            lineNum--;
        }
        return lines;
    }

    public <T> T parse(String jsonString, TypeReference<T> type) throws Exception {
        return mapper.readValue(jsonString, type);
    }

    public int[][] parse2dIntArray(String jsonString) throws Exception {
        List<List<Integer>> list = parse(jsonString, new TypeReference<List<List<Integer>>>() {});

        return list.stream().map(i->i.stream().mapToInt(j->j).toArray()).toArray(int[][]::new);
    }

    public String[][] parse2dStringArray(String jsonString) throws Exception {
        List<List<String>> list = parse(jsonString, new TypeReference<List<List<String>>>() {});

        return list.stream().map(List::toArray).toArray(String[][]::new);
    }
}
