package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1347 {
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if ( map.containsKey(c) ) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println(map);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( map.containsKey(c) ) {
                if ( map.get(c) == 1 ) {
                    map.remove(c);
                } else {
                    map.replace(c, map.get(c) - 1);
                }
            } else {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution1347 solution1347 = new Solution1347();
        System.out.println(solution1347.minSteps("leetcode", "practice"));
    }
}
