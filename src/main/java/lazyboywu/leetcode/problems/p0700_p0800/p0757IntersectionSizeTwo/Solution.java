package lazyboywu.leetcode.problems.p0700_p0800.p0757IntersectionSizeTwo;

import java.util.*;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {
    public int intersectionSizeTwo1(int[][] intervals) {

        Arrays.sort(intervals,
                (int[] interval1, int[] interval2) -> interval1[0] == interval2[0] ? interval2[1] - interval1[1] : interval1[0] - interval2[0]
        );

        int n = intervals.length;
        int curIntervalStart = intervals[0][0];
        int curIntervalEnd = intervals[0][1];
        List<int[]> intersections = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int[] curInterval = intervals[i];

            // 无交集
            if (curInterval[0] >= curIntervalEnd) {
                intersections.add(new int[]{curIntervalStart, curIntervalEnd});
                curIntervalStart = curInterval[0];
                curIntervalEnd = curInterval[1];
            } else {
                if (curInterval[0] > curIntervalStart) {
                    curIntervalStart = curInterval[0];
                }
                if (curInterval[1] < curIntervalEnd) {
                    curIntervalEnd = curInterval[1];
                }
            }
        }
        intersections.add(new int[]{curIntervalStart, curIntervalEnd});


        System.out.println(Arrays.deepToString(intersections.toArray()));

        List<Integer> intersectionList = new ArrayList<>();

        for (int[] intersection : intersections) {
            int start = intersection[0];
            int end = intersection[1];

            if (intersectionList.size() == 0) {
                intersectionList.add(start);
                intersectionList.add(end);
            } else {
                if (start != intersectionList.get(intersectionList.size()-1)) {
                    intersectionList.add(start);
                }
                intersectionList.add(end);
            }
        }

        System.out.println(Arrays.deepToString(intersectionList.toArray()));
        return intersectionList.size();
    }
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        // System.out.println("排序后intervals：" + Arrays.deepToString(intervals));
        int n = intervals.length;
        int cur = intervals[n - 1][0];
        int next = intervals[n - 1][0] + 1;
        int ans = 2;
        List<Integer> list = new ArrayList<>();
        list.add(cur);
        list.add(next);
        for (int i = n - 2; i >= 0; i--) {
            // System.out.println("待比较区间：" + Arrays.toString(intervals[i]) + "\t当前集合S：" + list);
            if (intervals[i][1] >= next) {
                continue;
            } else if (intervals[i][1] < cur) {
                cur = intervals[i][0];
                next = intervals[i][0] + 1;
                ans = ans + 2;
                list.add(0, next);
                list.add(0, cur);
            } else {
                next = cur;
                cur = intervals[i][0];
                ans++;
                list.add(0, cur);
            }
        }
        return ans;
    }
}
