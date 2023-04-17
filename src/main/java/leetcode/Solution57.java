package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        boolean first = true;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if ( end < newInterval[0] ) {
                resultList.add(new int[]{start, end});
            } else if ( start > newInterval[1] ) {
                if ( first ) {
                    resultList.add(newInterval);
                }
                resultList.add(new int[]{start, end});
                first = false;
            } else {
                newInterval[0] = Math.min(newInterval[0], start);
                newInterval[1] = Math.max(newInterval[1], end);
            }
        }
        if ( first ) {
            resultList.add(newInterval);
        }

        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution57 solution57 = new Solution57();
        solution57.insert(new int[][]{new int[]{1,2}, new int[]{3,5}, new int[]{6,7}, new int[]{8,10}, new int[]{12,16}},
                new int[]{4, 8});
    }
}
