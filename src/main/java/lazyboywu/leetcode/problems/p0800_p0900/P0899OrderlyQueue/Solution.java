package lazyboywu.leetcode.problems.p0800_p0900.P0899OrderlyQueue;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {
    public String orderlyQueue(String s, int k) {

        int len = s.length();
        if (len <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        if (k == 1) {
            char[] smallest = chars.clone();
            for (int i = 1; i < len; i++) {
                char moveChar = chars[0];
                System.arraycopy(chars, 1, chars, 0, len - 1);
                chars[len-1] = moveChar;
                if (compareTo(chars, smallest) < 0) {
                    smallest = chars.clone();
                }
            }
            chars = smallest;
        } else {
            Arrays.sort(chars);
        }
        return String.valueOf(chars);
    }

    public int compareTo(char[] chars, char[] anotherChars) {
        int len1 = chars.length;
        int len2 = anotherChars.length;
        int lim = Math.min(len1, len2);

        int k = 0;
        while (k < lim) {
            char c1 = chars[k];
            char c2 = anotherChars[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
}
