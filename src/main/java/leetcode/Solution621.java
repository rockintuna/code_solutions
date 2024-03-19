package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int[] countArray = new int[26];
        for (char task : tasks) {
            countArray[task - 'A']++;
        }

        Arrays.sort(countArray);
        int max = countArray[25];
        int idle = (max - 1) * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(max - 1, countArray[i]);
        }
        return tasks.length + Math.max(idle, 0);
    }

    public static void main(String[] args) {
        Solution621 solution621 = new Solution621();
        solution621.leastInterval(new char[]{'a', 'b', 'a'}, 2);
    }


}
