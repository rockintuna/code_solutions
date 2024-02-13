package leetcode;

public class Solution2108 {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if ( isPalindromic(word) ) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindromic(String word) {
        for (int i = 0; i < word.length()/2; i++) {
            if ( word.charAt(i) != word.charAt(word.length() - 1 - i) ) {
                return false;
            }
        }
        return true;
    }
}
