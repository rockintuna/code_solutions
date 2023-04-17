package leetcode;

public class Solution926 {
    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();

        int preZeroCount = 0;
        int change = 1;
        int noChange = 0;
        int temp;

        for (int i = 0; i < chars.length; i++) {
            if ( chars[i] == '0' ) {
                preZeroCount++;
            } else {
                break;
            }
        }

        for (int i = preZeroCount; i < chars.length; i++) {
            if ( chars[i] == '0' ) {
                if ( chars[i-1] == '1' ) {
                    temp = change;
                    change = noChange + 1;
                    noChange = temp;
                } else {
                    change++;
                }
            } else {
                if ( chars[i-1] == '1' ) {
                    change++;
                }
            }
        }

        return Math.min(change, noChange);
    }

    public static void main(String[] args) {
        Solution926 solution926 = new Solution926();
        System.out.println(solution926.minFlipsMonoIncr("00011000"));
    }
}
