package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] == 0 ) {
                prefixSum[i+1] = prefixSum[i];
            } else {
                prefixSum[i+1] = prefixSum[i] + 1;
            }
        }


        Map<Integer, Integer> prefixSumCountMap = new HashMap<>();
        for (int i = 0; i < prefixSum.length; i++) {
            prefixSumCountMap.put(prefixSum[i], prefixSumCountMap.getOrDefault(prefixSum[i],0) + 1);
        }

        if ( goal != 0 ) {
            int result = 0;
            for (Integer i : prefixSumCountMap.keySet()) {
                if ( prefixSumCountMap.containsKey(i + goal) ) {
                    result += prefixSumCountMap.get(i) * prefixSumCountMap.get(i + goal);
                }
            }
            return result;
        } else {
            int result = 0;
            for (Integer i : prefixSumCountMap.keySet()) {
                Integer count = prefixSumCountMap.get(i);
                result += count * (count - 1) / 2;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution930 solution930 = new Solution930();
        System.out.println(solution930.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    }
}
