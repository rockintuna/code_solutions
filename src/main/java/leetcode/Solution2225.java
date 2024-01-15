package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Integer[] looseCountArr = new Integer[100000+1];
        for (int i = 0; i < matches.length; i++) {
            int[] match = matches[i];

            int winner = match[0];
            int looser = match[1];

            if ( looseCountArr[winner] == null ) {
                looseCountArr[winner] = 0;
            }
            if ( looseCountArr[looser] == null || looseCountArr[looser] == 0 ) {
                looseCountArr[looser] = 1;
            } else {
                looseCountArr[looser] = looseCountArr[looser] + 1;
            }
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < looseCountArr.length; i++) {
            Integer looseCount = looseCountArr[i];
            if ( looseCount == null ) {
                continue;
            }
            if ( looseCount == 0 ) {
                list1.add(i);
            } else if ( looseCount == 1 ) {
                list2.add(i);
            }
        }
        List<List<Integer>> result = new ArrayList<>(2);
        result.add(list1);
        result.add(list2);
        return result;
    }

    public static void main(String[] args) {
        Solution2225 solution2225 = new Solution2225();
    }
}
