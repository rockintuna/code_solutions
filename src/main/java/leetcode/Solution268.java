package leetcode;

import java.util.Arrays;

public class Solution268 {
    public int missingNumber(int[] nums) {
        int a = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            if ( num == a ) {
                a++;
            } else {
                return a;
            }
        }
        return a;
    }
}
