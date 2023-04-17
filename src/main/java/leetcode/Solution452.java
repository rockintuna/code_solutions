package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        System.out.println(Arrays.deepToString(points));
        return 1;
    }

    public static void main(String[] args) {
        Solution452 solution452 = new Solution452();
        //[10,16],[2,8],[1,6],[7,12]
        int[] point1 = new int[]{10,16};
        int[] point2 = new int[]{2,8};
        int[] point3 = new int[]{1,6};
        int[] point4 = new int[]{7,12};
        int[][] ints = new int[][]{point1, point2, point3, point4};
        System.out.println(solution452.findMinArrowShots(ints));
    }
}
