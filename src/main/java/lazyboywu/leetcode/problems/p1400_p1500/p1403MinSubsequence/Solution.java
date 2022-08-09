package lazyboywu.leetcode.problems.p1400_p1500.p1403MinSubsequence;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int len = nums.length;
        nums = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder()) // just use 'sorted()' for ascending order
                .mapToInt(Integer::intValue)
                .toArray();

        if (len > 1) {
            int preSum = IntStream.of(nums).sum();
            int endSum = 0;
            int index = 0;
            for (int i = len - 1; i >= 0; i--) {
                preSum -= nums[i];
                endSum += nums[i];
                if (preSum <= endSum) {
                    index = i;
                    break;
                }
            }

            nums = Arrays.copyOfRange(nums, 0, index+1);
        }

        List<Integer> ans = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        return ans;
    }
}
