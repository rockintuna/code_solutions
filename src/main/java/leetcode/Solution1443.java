package leetcode;

import java.util.*;

public class Solution1443 {

    private Map<Integer, Integer> nodeLengthMap = new HashMap<>();
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
//        for (int i = hasApple.size() - 1; i > 0; i--) {
//            if (hasApple.get(i)) {
//                saveReculsive(edges, i);
//            }
//        }

        nodeLengthMap.put(0, 0);
        for (int i = 1; i < n; i++) {
            saveReculsive(n, edges);
        }
        return 0;
    }

    private void saveReculsive(int i, int[][] edges) {
        if ( i == 0 ) {
            return;
        }

        for ( int[] edge : edges ) {
            if ( edge[1] == i ) {
                if ( nodeLengthMap.containsKey(edge[0]) ) {
                    nodeLengthMap.put(i, nodeLengthMap.get(edge[0]) + 1);
                } else {
                    saveReculsive(edge[0], edges);
                }

                break;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{new int[]{0,1},new int[]{0,2},new int[]{1,4},new int[]{1,5},new int[]{2,3},new int[]{2,6}};
        List<Boolean> hasApple = List.of(false,false,true,false,true,true,false);
        Solution1443 solution1443 = new Solution1443();
        System.out.println(solution1443.minTime(7, arr, hasApple));
    }
}
