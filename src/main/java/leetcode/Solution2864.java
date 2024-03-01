package leetcode;

public class Solution2864 {

    public String maximumOddBinaryNumber(String s) {
        int countOfOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == '1' ) {
                countOfOne += 1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < countOfOne - 1; i++) {
             result.append('1');
        }
        for (int i = 0; i < s.length()-countOfOne; i++) {
            result.append('0');
        }
        result.append('1');
        return result.toString();
    }

    public static void main(String[] args) {
        Solution2864 solution2864 = new Solution2864();
        System.out.println(solution2864.maximumOddBinaryNumber("10010110101010100101"));
    }
}
