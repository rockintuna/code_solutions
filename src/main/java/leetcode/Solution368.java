package leetcode;

import java.util.*;

public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if ( nums.length == 1 ) {
            return List.of(nums[0]);
        }

        int size = 0;

        List<Set<Integer>> dp = new ArrayList<>();
        Set<Integer> result = null;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            List<Set<Integer>> copyOfDp = new ArrayList<>(dp);
            for (int j = 0; j < dp.size(); j++) {
                Set<Integer> integers = dp.get(j);
                if ( isDivisible(integers, nums[i]) ) {
                    Set<Integer> newSet = new HashSet<>(integers);
                    newSet.add(nums[i]);
                    copyOfDp.add(newSet);
                }
            }
            copyOfDp.add(Set.of(nums[i]));
            dp = copyOfDp;
        }

        for (Set<Integer> integers : dp) {
            if ( integers.size() > size ) {
                size = integers.size();
                result = integers;
            }
        }
        return new ArrayList<>(result);
    }

    private boolean isDivisible(Set<Integer> set, int num) {
        boolean isDivisible = true;
        for (Integer integer : set) {
            if ( num % integer != 0 ) {
                isDivisible = false;
                break;
            }
        }
        return isDivisible;
    }

    public static void main(String[] args) {
        Solution368 solution368 = new Solution368();
//        int[] nums = {5,9,18,54,108,540,90,180,360,720};
        int[] nums = {1,2,4,8};
        List<Integer> result = solution368.largestDivisibleSubset(nums);
        System.out.println(result);
    }
}
