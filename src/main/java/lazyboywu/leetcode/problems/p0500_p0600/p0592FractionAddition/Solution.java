package lazyboywu.leetcode.problems.p0500_p0600.p0592FractionAddition;

import java.util.*;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {
    public String fractionAddition(String expression) {

        char sign = '+';
        char curSign = '+';
        int numerator = 0;
        int curNumerator = 0;
        int denominator = 0;
        int curDenominator = 0;

        // 为了计算最后一位，给后面补上一个符号
        expression += "+";

        int n = expression.length();
        int i = 0;

        // 首位符号修正
        if (expression.charAt(0) == '-') {
            curSign = '-';
            i = 1;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (;i < n; i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                stringBuffer.append(c);
            } else if (c == '/') {
                curNumerator = Integer.parseInt(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else if (c == '+' || c == '-') {
                curDenominator = Integer.parseInt(stringBuffer.toString());
                stringBuffer = new StringBuffer();

                // 将分母设置为公倍数
                if (denominator > 0 && denominator != curDenominator) {
                    int lcm = getLCM(denominator, curDenominator);
                    numerator *= (int) lcm / denominator;
                    curNumerator *= (int) lcm / curDenominator;
                    denominator = lcm;
                    curDenominator = lcm;
                }

                // 计算分数
                if (sign == curSign) {
                    numerator += curNumerator;
                } else {
                    sign = numerator > curNumerator ? sign : curSign;
                    numerator = Math.abs(numerator - curNumerator);
                }
                denominator = curDenominator;

                // 改变下轮计算符号
                curSign = c;
            }
        }

        // 约分
        if (numerator == 0) {
            denominator = 1;
        } else {
            int gcd = getGCD(numerator, denominator);
            denominator = denominator / gcd;
            numerator = numerator/ gcd;
        }

        String result = sign == '-' ? "-" : "";
        result += String.valueOf(numerator) + "/" + String.valueOf(denominator);
        return result;
    }


    // 最大公约数
    private static int getGCD(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
    // 最小公倍数
    private static int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }
}
