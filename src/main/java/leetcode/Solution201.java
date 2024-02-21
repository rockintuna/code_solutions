package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        Set<Integer> indexOfOne = new HashSet<>();
        String binaryString = Integer.toBinaryString(left);
        char[] chars = new char[32 - binaryString.length()];
        Arrays.fill(chars, '0');
        String s = String.copyValueOf(chars) + binaryString;
        for (int j = 0; j < s.length(); j++) {
            if ( s.charAt(j) == '1') {
                indexOfOne.add(j);
            }
        }

        for (int i = left + 1; i <= right; i++) {
            binaryString = Integer.toBinaryString(i);
            chars = new char[32 - binaryString.length()];
            Arrays.fill(chars, '0');
            s = String.copyValueOf(chars) + binaryString;
            for (Integer index : Set.copyOf(indexOfOne)) {
                if ( s.charAt(index) == '0') {
                    indexOfOne.remove(index);
                }
            }
            if ( indexOfOne.isEmpty() ) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ( indexOfOne.contains(i) ) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        Solution201 solution201 = new Solution201();
        System.out.println(solution201.rangeBitwiseAnd(600000000, 2147483645));
    }
}
