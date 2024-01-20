package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution907 {

    public int sumSubarrayMins(int[] arr) {
        int[] minArr = arr;
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += minArr[i];
        }

        for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < arr.length - j; i++) {
                minArr[i] = Math.min(minArr[i], minArr[i+1]);
                sum += minArr[i];
            }
        }

        return (int) (sum % 1000000007);
    }
}
