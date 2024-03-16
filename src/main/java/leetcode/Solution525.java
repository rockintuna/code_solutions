package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int subarr = 0;
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] == 0 ) {
                sum -= 1;
            } else {
                sum += 1;
            }

            if (sum == 0) {
                subarr = i + 1;
            } else if (map.containsKey(sum)) {
                subarr = Math.max(subarr, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return subarr;
    }
}
