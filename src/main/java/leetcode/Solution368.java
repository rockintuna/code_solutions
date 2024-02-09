package leetcode;

import java.util.*;

public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if ( nums.length == 1 ) {
            return List.of(nums[0]);
        }

        int size = 0;

        List<List<Integer>> dp = new ArrayList<>();
        List<Integer> result = null;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> copyOfDp = new ArrayList<>(dp);
            List<Integer> list = null;
            int maxSize = 0;
            for (int j = 0; j < dp.size(); j++) {
                List<Integer> integers = dp.get(j);
                if ( isDivisible(integers, nums[i]) ) {
                    if ( integers.size() > maxSize ) {
                        maxSize = integers.size();
                        list = integers;
                    }
                }
            }

            if ( list != null ) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(nums[i]);
                copyOfDp.add(newList);
            } else {
                copyOfDp.add(List.of(nums[i]));
            }
            dp = copyOfDp;
        }

        for (List<Integer> integers : dp) {
            if ( integers.size() > size ) {
                size = integers.size();
                result = integers;
            }
        }
        return result;
    }

    private boolean isDivisible(List<Integer> list, int num) {
        return num % list.get(list.size() - 1) == 0;
    }

    public static void main(String[] args) {
        Solution368 solution368 = new Solution368();
        int[] nums = {5,9,18,54,108,540,90,180,360,720};
//        int[] nums = {1,2,4,8};
        List<Integer> result = solution368.largestDivisibleSubset(nums);
        System.out.println(result);
    }
}
