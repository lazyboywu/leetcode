package lazyboywu.leetcode.problems.p0700_p0800.p769MaxChunksToSorted;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }
}
