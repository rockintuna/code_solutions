package leetcode;

public class Solution1750 {
    public int minimumLength(String s) {
        int head = 0;
        int tail = s.length() - 1;
        char c = 'd';

        while ( head <= tail ) {
            if ( head == tail ) {
                if ( s.charAt(head) == c ) {
                    return 0;
                } else {
                    return 1;
                }
            }

            if ( s.charAt(head) == s.charAt(tail) ) {
                c = s.charAt(head);
                head += 1;
                tail -= 1;
                continue;
            }
            if ( s.charAt(head) == c ) {
                head += 1;
                continue;
            }
            if ( s.charAt(tail) == c ) {
                tail -= 1;
                continue;
            }
            if ( s.charAt(head) != s.charAt(tail) ) {
                break;
            }
        }

        return tail - head + 1;
    }

    public static void main(String[] args) {
        Solution1750 solution1750 = new Solution1750();
        System.out.println(solution1750.minimumLength("abbbbbbbbbbbbbbbbbbba"));
    }
}
