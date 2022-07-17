package lazyboywu.leetcode.problems.p0500_p0600.p0565ArrayNesting;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] usedNums = new boolean[nums.length];

        int longest = 0;

        for (int num : nums) {

            // 已经使用过，必定在另一个循环中
            if (usedNums[num]) {
                continue;
            }

            int cur = num;
            int longer = 0;
            do {
                cur = nums[cur];
                usedNums[cur] = true;
                longer++;
            } while (cur != num);

            if (longer > longest) {
                longest = longer;
            }

            longest = Math.max(longest, longer);
        }

        return longest;
    }
}
