package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1291 {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> result = new ArrayList<>();
        addSequentialDigits(result, 12, low, high);
        addSequentialDigits(result, 23, low, high);
        addSequentialDigits(result, 34, low, high);
        addSequentialDigits(result, 45, low, high);
        addSequentialDigits(result, 56, low, high);
        addSequentialDigits(result, 67, low, high);
        addSequentialDigits(result, 78, low, high);
        addSequentialDigits(result, 89, low, high);

        return result.stream().sorted().collect(Collectors.toList());
    }

    private void addSequentialDigits(List<Integer> result, int num, int low, int high) {
        if ( low <= num ) {
            if (high >= num) {
                result.add(num);
                int lastDigit = num % 10;
                if ( lastDigit < 9 ) {
                    int newNum = num * 10 + lastDigit + 1;
                    addSequentialDigits(result, newNum, low, high);
                }
            }
        } else {
            int lastDigit = num % 10;
            if ( lastDigit < 9 ) {
                int newNum = num * 10 + lastDigit + 1;
                addSequentialDigits(result, newNum, low, high);
            }
        }
    }
}
