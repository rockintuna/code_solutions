package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution1208 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if ( map.containsKey(i1) ) {
                map.replace(i1, map.get(i1) + 1);
            } else {
                map.put(i1, 1);
            }
        }

        int x = 0;
        List<Integer> collect = map.values().stream().sorted().collect(Collectors.toList());
        for (Integer i : collect) {
            if ( x == i ) {
                return false;
            } else {
                x = i;
            }
        }
        return true;
    }
}
