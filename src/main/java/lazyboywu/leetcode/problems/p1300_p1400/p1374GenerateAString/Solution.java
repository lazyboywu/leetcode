package lazyboywu.leetcode.problems.p1300_p1400.p1374GenerateAString;

import java.util.Collections;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {
    public String generateTheString(int n) {
        // 26 (1 3 5 ... 1 + 2*26) = 676

        int m = 26;
        StringBuffer stringBuffer = new StringBuffer();
        int s = 0;
        for (int i = 0; i < m; i++) {
            int d = 2 * i + 1;
            char c = (char) ('a' + i);
            if (s + d >= n) {
                int dd = n - s;
                if (dd % 2 == 0) {
                    repate(stringBuffer, c, dd - 1);
                    repate(stringBuffer, (char) (c + 1), 1);
                } else {
                    repate(stringBuffer, c, dd);
                }
                break;
            } else {
                repate(stringBuffer, c, d);
                s += d;
            }
        }
        return stringBuffer.toString();
    }

    public void repate(StringBuffer stringBuffer, char c, int n) {
        for(int i = 0;i < n; i++){
            stringBuffer.append(c);
        }
    }
}
