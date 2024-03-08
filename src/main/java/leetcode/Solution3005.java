package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution3005 {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        int max = 0;
        for (Integer i : map.values()) {
            if ( max < i ) {
                max = i;
                System.out.println(max);
                count = 1;
            } else if ( max == i ) {
                count += 1;
            }
        }
        return count * max;
    }
}
