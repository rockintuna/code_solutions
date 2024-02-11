package leetcode;

public class Solution647 {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            count += addPalindromicSubStringStartOn(i, s, sb);
        }
        return count;
    }

    private int addPalindromicSubStringStartOn(int index, String s, StringBuilder sb) {
        if ( index > s.length() - 1 ) {
            return 0;
        }

        int count = 0;
        sb.append(s.charAt(index));
        if ( isPalindromic(sb) ) {
            count += 1;
        }
        count += addPalindromicSubStringStartOn(index + 1, s, sb);
        return count;
    }

    private boolean isPalindromic(StringBuilder sb) {
        if ( sb.length() == 1 ) {
            return true;
        }
        for (int i = 0; i < sb.length()/2; i++) {
            if ( sb.charAt(i) != sb.charAt(sb.length() - 1 - i) ) {
                return false;
            }
        }
        return true;
    }
}
