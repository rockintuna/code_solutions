package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1291_2 {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> sequentialDigits = new ArrayList<>();
        sequentialDigits.add(12);
        sequentialDigits.add(23);
        sequentialDigits.add(34);
        sequentialDigits.add(45);
        sequentialDigits.add(56);
        sequentialDigits.add(67);
        sequentialDigits.add(78);
        sequentialDigits.add(89);
        sequentialDigits.add(123);
        sequentialDigits.add(234);
        sequentialDigits.add(345);
        sequentialDigits.add(456);
        sequentialDigits.add(567);
        sequentialDigits.add(678);
        sequentialDigits.add(789);
        sequentialDigits.add(1234);
        sequentialDigits.add(2345);
        sequentialDigits.add(3456);
        sequentialDigits.add(4567);
        sequentialDigits.add(5678);
        sequentialDigits.add(6789);
        sequentialDigits.add(12345);
        sequentialDigits.add(23456);
        sequentialDigits.add(34567);
        sequentialDigits.add(45678);
        sequentialDigits.add(56789);
        sequentialDigits.add(123456);
        sequentialDigits.add(234567);
        sequentialDigits.add(345678);
        sequentialDigits.add(456789);
        sequentialDigits.add(1234567);
        sequentialDigits.add(2345678);
        sequentialDigits.add(3456789);
        sequentialDigits.add(12345678);
        sequentialDigits.add(23456789);
        sequentialDigits.add(123456789);

        List<Integer> result = new ArrayList<>();
        for (Integer sequentialDigit : sequentialDigits) {
            if ( low <= sequentialDigit && sequentialDigit <= high ) {
                result.add(sequentialDigit);
            }
        }

        return result;
    }
}
