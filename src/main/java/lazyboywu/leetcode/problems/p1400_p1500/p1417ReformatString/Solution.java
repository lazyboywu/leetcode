package lazyboywu.leetcode.problems.p1400_p1500.p1417ReformatString;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {

    static final int CHAR = 0;
    static final int DIGIT = 1;

    public String reformat(String s) {
        String[] sSplited = split(s);

        int diff = sSplited[CHAR].length() - sSplited[DIGIT].length();

        String ans = "";
        if (diff == 0) {
            ans = merge(sSplited[CHAR], sSplited[DIGIT]);
        } else if (diff == -1) {
            ans = merge(sSplited[CHAR], sSplited[DIGIT]);
        } else if (diff == 1) {
            ans = merge(sSplited[DIGIT], sSplited[CHAR]);
        }

        return ans;
    }

    public String merge(String sMin, String sMax) {
        int len = sMin.length();

        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (; i < len; i++) {
            stringBuffer.append(sMax.charAt(i)).append(sMin.charAt(i));
        }
        if (i < sMax.length()) {
            stringBuffer.append(sMax.charAt(i));
        }
        return stringBuffer.toString();
    }

    public String[] split(String s) {
        int len = s.length();
        String[] result = new String[2];

        StringBuffer sbChar = new StringBuffer();
        StringBuffer sbDigit = new StringBuffer();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {

                sbDigit.append(c);
            } else {
                sbChar.append(c);
            }
        }

        result[CHAR] = sbChar.toString();
        result[DIGIT] = sbDigit.toString();

        return result;
    }
}
