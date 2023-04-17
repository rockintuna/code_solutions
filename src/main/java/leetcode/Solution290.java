package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] strings = s.split(" ");

        if ( pattern.length() != strings.length ) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if ( map.containsKey(pattern.charAt(i)) ) {
                if ( !map.get(pattern.charAt(i)).equals(strings[i]) ) {
                    return false;
                }
            } else {
                if ( map.containsValue(strings[i]) ) {
                    return false;
                }
                map.put(pattern.charAt(i), strings[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution290 solution290 = new Solution290();
        System.out.println(solution290.wordPattern("abbc", "dog cat cat dog"));
    }
}
