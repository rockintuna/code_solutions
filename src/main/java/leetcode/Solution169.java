package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = elementCountMap.getOrDefault(num, 0) + 1;
            if ( count > nums.length / 2 ) {
                return num;
            }
            elementCountMap.put(num, count);
        }
        return 0;
    }
}
