package leetcode;

import java.util.Arrays;

public class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int result = 0;
        for (int i = 0; i < costs.length; i++) {
            coins -= costs[i];
            if ( coins <= 0 ) {
                if ( coins == 0 ) {
                    result = i+1;
                } else {
                    result = i;
                }
                break;
            }
        }

        if ( coins > 0 ) {
            return costs.length;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1833 solution1833 = new Solution1833();

        System.out.println(solution1833.maxIceCream(new int[]{1,3,2,4,1}, 7));
    }
}
