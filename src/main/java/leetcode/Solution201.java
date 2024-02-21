package leetcode;

public class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right = right & (right - 1);
        }
        return right & left;
    }

    public static void main(String[] args) {
        Solution201 solution201 = new Solution201();
        System.out.println(solution201.rangeBitwiseAnd(600000000, 2147483645));
    }
}
