package leetcode;

public class Solution70 {
    public int climbStairs(int n) {
        int[] ints = new int[46];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;

        for (int i = 3; i < ints.length; i++) {
            ints[i] = ints[i-2] + ints[i-1];
        }

        return ints[n];
    }
}
