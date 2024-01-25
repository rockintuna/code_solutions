package leetcode;

public class Solution1143 {

    private String target;
    private String stand;

    public int longestCommonSubsequence(String text1, String text2) {
        if ( text1.length() > text2.length() ) {
            target = text1;
            stand = text2;
        } else {
            stand = text1;
            target = text2;
        }

        StringBuilder subsequence = new StringBuilder();

        int max = 0;
        for (int i = 0; i < stand.length(); i++) {
            max = Math.max(max, findMaxSubSequenceLength(subsequence, i, 0));
        }
        return max;
    }

    private int findMaxSubSequenceLength(StringBuilder builder, int standIndex, int pin) {
        if ( standIndex == stand.length() ) {
            return builder.length();
        }

        char c = stand.charAt(standIndex);
        int i = target.indexOf(c);
        if ( i == -1 ) {
            return findMaxSubSequenceLength(builder, standIndex+1, pin);
        } else if ( i < pin ) {
            return findMaxSubSequenceLength(builder, standIndex+1, pin);
        }

        builder.append(c);
        int maxSubSequenceLength = findMaxSubSequenceLength(builder, standIndex + 1, pin + 1);
        builder.deleteCharAt(builder.length()-1);
        return maxSubSequenceLength;
    }

    public static void main(String[] args) {
        String str = "test";
        System.out.println(str.indexOf('e'));
    }
}
