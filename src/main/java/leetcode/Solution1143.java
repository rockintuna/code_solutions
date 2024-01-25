package leetcode;

import java.util.Arrays;

public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return findMaxSubSequenceLength(text1, text2, 0, 0, dp);
    }

    private int findMaxSubSequenceLength(String text1, String text2, int index1, int index2,
                                         int[][] dp) {
        if (index1 == text1.length() || index2 == text2.length()) {
            return 0;
        }

        if ( dp[index1][index2] != -1 ) {
            return dp[index1][index2];
        }

        int count = 0;
        if (text1.charAt(index1) == text2.charAt(index2)) {
            count = 1 + findMaxSubSequenceLength(text1, text2, index1+1, index2+1, dp);
        } else {
            count = Math.max(findMaxSubSequenceLength(text1, text2, index1+1, index2, dp),
                    findMaxSubSequenceLength(text1, text2, index1, index2+1, dp));
        }

        dp[index1][index2] = count;
        return dp[index1][index2];
    }

    public static void main(String[] args) {
        String str = "test";
        System.out.println(str.indexOf('e'));
    }
}
