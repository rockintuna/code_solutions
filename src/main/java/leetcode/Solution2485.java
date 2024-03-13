package leetcode;

public class Solution2485 {
    public int pivotInteger(int n) {
        int left = 1;
        int right = 0;
        for (int i = 1; i <= n; i++) {
            right += i;
        }

        for (int i = 1; i <= n; i++) {
            if ( left == right ) {
                return i;
            }
            left += i + 1;
            right = right - i;
        }
        return -1;
    }
}
