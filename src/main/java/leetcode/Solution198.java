package leetcode;

import java.util.Stack;

public class Solution198 {

    private int max;
    private int[] nums;

    public int rob(int[] nums) {
        this.max = 0;
        this.nums = nums;
        sumNext(0, 0);
        sumNext(0, 1);

        return max;
    }

    private void sumNext(int sum, int index) {
        if ( index >= nums.length ) {
            this.max = Math.max(this.max, sum);
            return;
        }

        sum += this.nums[index];
        sumNext(sum, index + 2);
        sumNext(sum, index + 3);
    }
}
