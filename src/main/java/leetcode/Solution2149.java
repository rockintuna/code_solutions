package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2149 {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positiveNums = new ArrayList<>();
        List<Integer> negativeNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] > 0 ) {
                positiveNums.add(nums[i]);
            } else {
                negativeNums.add(nums[i]);
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length/2; i++) {
            result[i*2] = positiveNums.get(i);
            result[i*2+1] = negativeNums.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution2149 solution2149 = new Solution2149();
        int[] ints = solution2149.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4});
        System.out.println(Arrays.toString(ints));
    }
}
