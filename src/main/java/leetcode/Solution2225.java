package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> playerAndLoseCountMap = new HashMap<>();
        Set<Integer> playerSet = new HashSet<>();

        for (int i = 0; i < matches.length; i++) {
            int[] match = matches[i];
            int winner = match[0];
            int looser = match[1];
            playerSet.add(winner);
            playerSet.add(looser);

            if ( playerAndLoseCountMap.containsKey(looser) ) {
                playerAndLoseCountMap.replace(looser, playerAndLoseCountMap.get(looser) + 1);
            } else {
                playerAndLoseCountMap.put(looser, 1);
            }
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Integer i : playerSet) {
            if ( playerAndLoseCountMap.get(i) == null ) {
                list1.add(i);
            } else if ( playerAndLoseCountMap.get(i) == 1 ) {
                list2.add(i);
            }
        }

        List<List<Integer>> result = new ArrayList<>(2);
        result.add(list1.stream().sorted().collect(Collectors.toList()));
        result.add(list2.stream().sorted().collect(Collectors.toList()));
        return result;
    }

    public static void main(String[] args) {
        Solution2225 solution2225 = new Solution2225();
    }
}
