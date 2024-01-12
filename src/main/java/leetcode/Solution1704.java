package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution1704 {

    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int length = s.length();
        String a = s.substring(0, length/2);
        String b = s.substring(length/2);

        int aCount = 0;
        int bCount = 0;

        for (int i = 0; i < length/2; i++) {
            if ( vowels.contains(a.charAt(i)) ) {
                aCount++;
            }
            if ( vowels.contains(b.charAt(i)) ) {
                bCount++;
            }
        }

        if ( aCount == bCount ) {
            return true;
        } else {
            return false;
        }
    }
}