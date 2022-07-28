package lazyboywu.leetcode.problems.p0001_p0100.p0009PalindromeNumber;

import java.util.Map;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {

    // 2147483648 = 10bit

    static int[] intMap = {
            0, 1, 10, 100, 1000, 10000,
            100000, 1000000, 10000000,
            100000000, 1000000000,
    };
    static int intMapLen = intMap.length;

    public boolean isPalindrome(int x) {
        // 所有负数
        if (x < 0) {
            return false;
        } else if (x < 10) {
            // 0 - 9
            return true;
        }

        // 判断数字的位数
        int p = 2;
        for (;p < intMapLen - 1;p++) {
            if (x < intMap[p+1]) {
                break;
            }
        }

        int m;
        if (p % 2 == 0) {
            m = p / 2;
        } else {
            m = (p - 1) / 2;
        }

        for (int i = 1; i <= m; i++) {
            if (get10Bit(x, i) != get10Bit(x, p - i + 1)) {
                return false;
            }
        }

        return true;
    }

    public int get10Bit(int x, int b) {
        if (b < intMapLen - 1) {
            x = x % intMap[b+1];
        }
        if (b == 0) {
            return x;
        }
        if (x < intMap[b]) {
            return 0;
        }
        return x / intMap[b];
    }
}
