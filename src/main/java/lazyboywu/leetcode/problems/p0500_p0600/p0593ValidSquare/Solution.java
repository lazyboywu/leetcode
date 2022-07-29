package lazyboywu.leetcode.problems.p0500_p0600.p0593ValidSquare;

import java.util.Arrays;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {
    static int x = 0;
    static int y = 1;

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        double p1p2 = distance(p1, p2);
        double p1p3 = distance(p1, p3);
        double p1p4 = distance(p1, p4);

        if (p1p2 == 0 || p1p3 == 0 || p1p4 == 0){
            return false;
        }

        // p1p2是对角线？
        if (p1p2 > p1p3) {
            int[] pTmp = p2;
            p2 = p3;
            p3 = pTmp;

            double ppTmp = p1p2;
            p1p2 = p1p3;
            p1p3 = ppTmp;
        } else
        // p1p4是对角线？
        if (p1p4 > p1p3) {
            int[] pTmp = p4;
            p4 = p3;
            p3 = pTmp;

            double ppTmp = p1p4;
            p1p4 = p1p3;
            p1p3 = ppTmp;
        }

        // 经过上述处理后理论上 p1 -> p2 -> p3 -> p4 为一个连续图像
        double p2p3 = distance(p2, p3);
        double p2p4 = distance(p2, p4);
        double p3p4 = distance(p3, p4);

        // 4边是否相等？
        if (p1p2 != p1p4 || p1p2 != p2p3 || p2p3 != p3p4 || p3p4 != p1p4) {
            return false;
        }

        // 以p1为起点判断临边和斜边
        if (!isGouGu(p1, p2, p4, p2p4)) {
            return false;
        }
        // 以p2为起点判断临边和斜边
        if (!isGouGu(p2, p1, p3, p1p3)) {
            return false;
        }
        // 以p3为起点判断临边和斜边
        if (!isGouGu(p3, p2, p4, p2p4)) {
            return false;
        }
        // 以p4为起点判断临边和斜边
        if (!isGouGu(p4, p1, p3, p1p3)) {
            return false;
        }

        return true;
    }

    public double distance(int[] p1, int[] p2) {
        return Math.sqrt(distanceSqrt(p1, p2));
    }

    public double distanceSqrt(int[] p1, int[] p2) {
        int xSeparation = Math.abs(p1[x] - p2[x]);
        int ySeparation = Math.abs(p1[y] - p2[y]);
        return xSeparation * xSeparation + ySeparation * ySeparation;
    }

    // 勾股定理
    public boolean isGouGu(int[] p1, int[] p2, int[] p3, double p2p3) {
        return Math.sqrt(distanceSqrt(p1, p2) + distanceSqrt(p1, p3)) == p2p3;
    }
}
