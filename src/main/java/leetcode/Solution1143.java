package leetcode;

public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        return findMaxSubSequenceLength(text1, text2, 0, 0);
    }

    private int findMaxSubSequenceLength(String text1, String text2, int index1, int index2) {
        if (index1 == text1.length() || index2 == text2.length()) {
            return 0;
        }

        int count = 0;
        if (text1.charAt(index1) == text2.charAt(index2)) {
            count = 1 + findMaxSubSequenceLength(text1, text2, index1+1, index2+1);
        } else {
            count = Math.max(findMaxSubSequenceLength(text1, text2, index1+1, index2),
                    findMaxSubSequenceLength(text1, text2, index1, index2+1));
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "test";
        System.out.println(str.indexOf('e'));
    }
}
