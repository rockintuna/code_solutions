package leetcode;

import java.util.Stack;

public class Solution232 {

    class MyQueue {

        private final Stack<Integer> saveStack;
        private final Stack<Integer> returnStack;

        public MyQueue() {
            saveStack = new Stack<>();
            returnStack = new Stack<>();
        }

        public void push(int x) {
            saveStack.push(x);
        }

        public int pop() {
            if ( returnStack.isEmpty() ) {
                moveSaveStackToReturnStack();
            }
            return returnStack.pop();
        }

        public int peek() {
            if ( returnStack.isEmpty() ) {
                moveSaveStackToReturnStack();
            }
            return returnStack.peek();
        }

        private void moveSaveStackToReturnStack() {
            while ( !saveStack.isEmpty() ) {
                returnStack.push(saveStack.pop());
            }
        }

        public boolean empty() {
            return returnStack.isEmpty() && saveStack.isEmpty();
        }
    }


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
