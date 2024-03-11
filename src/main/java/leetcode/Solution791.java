package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution791 {
    public String customSortString(String order, String s) {
        StringBuilder remain = new StringBuilder();

        List<Character> orderList = new ArrayList<>();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderList.add(order.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if ( order.contains(""+s.charAt(i)) ) {
                countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
            } else {
                remain.append(s.charAt(i));
            }
        }

        for (Character c : orderList) {
            if ( countMap.containsKey(c) ) {
                remain.append(String.valueOf(c).repeat(Math.max(0, countMap.get(c))));
            }
        }
        return remain.toString();
    }

    public static void main(String[] args) {
        Solution791 solution791 = new Solution791();
        String s = solution791.customSortString("cba", "abcd");
        System.out.println(s);
    }
}
