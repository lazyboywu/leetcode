package lazyboywu.leetcode.problems.p1200_p1300.p1282GroupThePeople;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        int len = groupSizes.length;

        // <groupSize, ansIndex>
        HashMap<Integer, Integer> groupMap = new HashMap<>();

        List<List<Integer>> ans = new ArrayList<>();
        int ansIndex = 0;
        for (int id = 0; id < len; id++) {
            int groupSize = groupSizes[id];
            List<Integer> group;

            // 组不存在
            if (!groupMap.containsKey(groupSize)) {
                group = new ArrayList<>();
                ans.add(group);
                groupMap.put(groupSize, ansIndex);
                ansIndex++;
            } else {
                // 获取组
                group = ans.get(groupMap.get(groupSize));
            }

            // 组满了
            if (group.size() == groupSize) {
                group = new ArrayList<>();
                ans.add(group);
                groupMap.put(groupSize, ansIndex);
                ansIndex++;
            }

            group.add(id);
        }
        return ans;
    }
}
