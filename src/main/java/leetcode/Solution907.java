package leetcode;

import java.util.Stack;

public class Solution907 {

    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        stack.push(-1);

        for (int i= 0; i < arr.length+1; i++){
            int currVal;
            if ( i <= arr.length-1 ) {
                currVal = arr[i];
            } else {
                currVal = 0;
            }
            while( stack.peek() != -1 && currVal < arr[stack.peek()] ){
                int index = stack.pop();
                int j = stack.peek();
                int left = index - j;
                int right = i - index;
                sum += (left * right * (long) arr[index] ) % 1000000007 ;
                sum %= 1000000007;
            }
            stack.push(i);
        }

        return (int) sum;
    }
}
