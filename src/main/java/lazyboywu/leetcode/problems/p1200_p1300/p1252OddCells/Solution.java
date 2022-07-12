package lazyboywu.leetcode.problems.p1200_p1300.p1252OddCells;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int[] index : indices) {
            rows[index[0]] = !rows[index[0]];
            cols[index[1]] = !cols[index[1]];
        }

        int oddNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] ^ cols[j]) {
                    oddNum += 1;
                }
            }
        }
        return oddNum;
    }
}
