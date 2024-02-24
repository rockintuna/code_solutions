package leetcode;

import java.util.*;

public class Solution997 {
    public int findJudge(int n, int[][] trust) {
        if ( trust.length == 0 ) {
            if ( n == 1 ) {
                return 1;
            } else {
                return -1;
            }
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < trust.length; i++) {

            int[] trustRel = trust[i];
            // a trust b
            int a = trustRel[0];
            int b = trustRel[1];

            Set<Integer> trustList = map.getOrDefault(b, new HashSet<>());
            trustList.add(a);
            map.put(b, trustList);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if ( entry.getValue().size() == n - 1 ) {
                boolean trustOther = false;
                for (Set<Integer> value : map.values()) {
                    if ( value.contains(entry.getKey()) ) {
                        trustOther = true;
                        break;
                    }
                }

                if ( !trustOther ) {
                    return entry.getKey();
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution997 solution997 = new Solution997();
    }
}
