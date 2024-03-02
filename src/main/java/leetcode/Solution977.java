package leetcode;

import java.util.Arrays;

public class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            result[i] = num * num;
        }

        Arrays.sort(result);
        return result;
    }
}
