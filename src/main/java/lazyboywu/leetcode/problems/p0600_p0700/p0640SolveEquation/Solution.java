package lazyboywu.leetcode.problems.p0600_p0700.p0640SolveEquation;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {

    static final int coefficient = 0;
    static final int constant = 1;

    public String solveEquation(String equation) {

        String[] expressions = equation.split("=");

        // int[] 0 -> x的系数 1 -> 常数
        int[] left = simplifyExpression(expressions[0]);
        int[] right = simplifyExpression(expressions[1]);

        // 等式常数化为0
        if (left[constant] != 0 && right[constant] != 0) {
            if (left[constant] > right[constant]) {
                left[constant] -= right[constant];
                right[constant] = 0;
            } else {
                right[constant] -= left[constant];
                left[constant] = 0;
            }
        }

        String ans;

        // 判断是否有常数
        if (left[constant] != 0 || right[constant] != 0) {
            int diff = left[coefficient] - right[coefficient];
            if (diff == 0) {
                ans = "No solution";
            } else if (left[constant] == 0) {
                ans = "x=" + String.valueOf(right[constant] / diff);
            } else if(right[constant] == 0) {
                ans = "x=" + String.valueOf(-left[constant] / diff);
            } else {
                ans = "No solution";
            }
        } else if (left[coefficient] != right[coefficient]) {
            ans = "x=0";
        } else {
            ans = "Infinite solutions";
        }

        return ans;
    }

    /**
     * int[] 0 -> x的系数 1 -> 常数
     * @param expression
     * @return
     */
    public int[] simplifyExpression(String expression) {


        // 默认数字开头
        int current = constant;

        int[] result = new int[2];

        // 补足正号以便计算
        char sign = '+';
        int i = 0;
        if (expression.charAt(0) == '-') {
            sign = '-';
            i = 1;
        }

        // 后面补正号，便于循环结束
        expression += '+';
        StringBuilder num = new StringBuilder();
        int len = expression.length();

        for (;i < len; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-') {

                if (sign == '+') {
                    result[current] += Integer.parseInt(num.toString());
                } else {
                    result[current] -= Integer.parseInt(num.toString());
                }

                // 记录符号
                sign = c;
                // 默认数字开头
                current = constant;
                // 清空num
                num = new StringBuilder();
            } else if (c == 'x') {
                current = coefficient;
                if (num.length() == 0) {
                    num.append("1");
                }
            } else {
                num.append(c);
            }
        }

        return result;
    }
}
