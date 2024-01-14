package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution1657 {
    public boolean closeStrings(String word1, String word2) {
        //operation 1 => 순서 상관 없음
        //operation 2 => 크기는 같아야 함
        if ( word1.length() != word2.length() ) {
            return false;
        }

        Map<Character, Integer> word1Map = new HashMap<>();
        Map<Character, Integer> word2Map = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            if ( word1Map.containsKey(word1.charAt(i)) ) {
                word1Map.replace(word1.charAt(i), word1Map.get(word1.charAt(i)) + 1);
            } else {
                word1Map.put(word1.charAt(i), 1);
            }
        }
        for (int i = 0; i < word2.length(); i++) {
            if ( word2Map.containsKey(word2.charAt(i)) ) {
                word2Map.replace(word2.charAt(i), word2Map.get(word2.charAt(i)) + 1);
            } else {
                word2Map.put(word2.charAt(i), 1);
            }
        }
        //operation 2 => 캐릭터 종류는 같아야함
        if ( word1Map.keySet().size() != word2Map.keySet().size() ) {
            return false;
        }
        for (Character c : word1Map.keySet()) {
            if ( !word2Map.containsKey(c) ) {
                return false;
            }
        }
        //operation 2 => 캐릭터별 개수는 같아야함
        List<Integer> sortedList1 = word1Map.values().stream().sorted().collect(Collectors.toList());
        List<Integer> sortedList2 = word2Map.values().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < sortedList1.size(); i++) {
             if (!sortedList1.get(i).equals(sortedList2.get(i))) {
                 return false;
             }
        }
         return true;
    }

    public static void main(String[] args) {
        Solution1657 solution1657 = new Solution1657();
        System.out.println(solution1657.closeStrings("a", "aa"));
    }
}
