package leetcode;

import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String sortedString = sortString(str);

            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(str);
            } else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                map.put(sortedString, newGroup);
            }
        }

        return new ArrayList<>(map.values());
    }

    private static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return Arrays.toString(charArray);
    }
}
