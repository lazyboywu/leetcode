package lazyboywu.leetcode.problems.p0700_p0800.p0735AsteroidCollision;

import java.util.Stack;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> outputStack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int origin = asteroids[i];

            if (outputStack.empty()) {
                outputStack.push(origin);
                continue;
            }

            int output = outputStack.peek();

            if(origin < 0 && output > 0) {
                int diff = output + origin;
                if (diff == 0) {
                    outputStack.pop();
                } else if (diff < 0) {
                    outputStack.pop();
                    i--;
                }
            } else {
                outputStack.push(origin);
            }
        }

        int size = outputStack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = outputStack.pop();
        }

        return ans;
    }
}
