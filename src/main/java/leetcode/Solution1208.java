package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

        int size = map.size();
        if ( arr.length < (size+1)*size/2 ) {
            return false;
        }

        Set<Integer> countSet = new HashSet<>();

        for (Integer value : map.values()) {
            if ( countSet.contains(value) ) {
                return false;
            } else {
                countSet.add(value);
            }
        }
        return true;
    }
}
