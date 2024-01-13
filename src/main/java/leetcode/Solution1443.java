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
}
