package lazyboywu.leetcode.problems.p1300_p1400.p1331RankTransformOfAnArray;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {
    // public int[] arrayRankTransform(int[] arr) {
    //     List<Integer> sort = Arrays.stream(arr).distinct().sorted().boxed().collect(Collectors.toList());
    //
    //     return Arrays.stream(arr).map(i -> sort.indexOf(i) + 1).toArray();
    // }

    static Map<Integer, Integer> indexMap = new HashMap<>();

    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;

        int[] sorted = Arrays.copyOf(arr, len);
        Arrays.sort(sorted);

        indexMap.clear();

        int index = 0;
        int last = 0;
        for (int i = 0; i < len; i++) {
            if (last != sorted[i]) {
                index += 1;
                last = sorted[i];
                indexMap.put(last, index);
            }
        }

        for (int i = 0; i < len; i++) {
            sorted[i] = indexMap.get(arr[i]);
        }

        return sorted;
    }
}
