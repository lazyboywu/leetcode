package lazyboywu.leetcode.problems.p1400_p1500.p1413MinStartValue;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {
    public int minStartValue(int[] nums) {
        int min = Integer.MIN_VALUE;
        int startValue = 1;
        while (min < 1) {
            int num = startValue;
            for (int n : nums) {
                num += n;
                if (min == Integer.MIN_VALUE) {
                    min = num;
                } else if (num < min) {
                    min = num;
                }
            }
            if (min < 0) {
                startValue += Math.abs(min);
                min = Integer.MIN_VALUE;
            } else if (min == 0) {
                startValue += 1;
                min = Integer.MIN_VALUE;
            }
        }

        return startValue;
    }
}
