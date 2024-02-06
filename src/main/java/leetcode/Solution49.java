package leetcode;

import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String string = Arrays.toString(charArray);

            if ( map.containsKey(string) ) {
                map.get(string).add(str);
            } else {
                List<String> objects = new ArrayList<>();
                objects.add(str);
                map.put(string, objects);
            }
        }

        return new ArrayList<>(map.values());
    }
}
