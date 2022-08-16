package lazyboywu.leetcode.problems.p1600_p1700.p1656OrderedStream;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
class OrderedStream {

    String[] values;
    int ptr;
    int len;

    public OrderedStream(int n) {
        len = n + 1;
        values = new String[len];
        ptr = 1;

    }

    public List<String> insert(int id, String value) {
        values[id] = value;
        List<String> ans = new ArrayList<>();
        while (ptr < len && values[ptr] != null){
            ans.add(values[ptr]);
            ptr++;
        }
        return ans;
    }
}