package leetcode;

public class Solution198 {

    private int[] nums;
    private Integer[] maxs;

    public int rob(int[] nums) {
        if ( nums.length == 1 ) {
            return nums[0];
        }

        this.nums = nums;
        this.maxs = new Integer[nums.length];
        sumNext(0);
        sumNext(1);

        return Math.max(this.maxs[0], this.maxs[1]);
    }

    private void sumNext(int index) {
        if ( index >= nums.length ) {
            return;
        }
        if ( index >= nums.length - 2 ) {
            this.maxs[index] = this.nums[index];
            return;
        }
        if ( index == nums.length - 3 ) {
            if ( maxs[index+2] == null ) {
                sumNext(index + 2);
            }
            int max = this.maxs[index + 2];
            this.maxs[index] = max + this.nums[index];
            return;
        }

        if ( maxs[index+2] == null ) {
            sumNext(index + 2);
        }
        if ( maxs[index+3] == null ) {
            sumNext(index + 3);
        }
        int max = Math.max(this.maxs[index + 2], this.maxs[index + 3]);
        this.maxs[index] = max + this.nums[index];
    }
}
