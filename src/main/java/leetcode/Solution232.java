package leetcode;

import java.util.Stack;

public class Solution232 {

    class MyQueue {

        private Stack<Integer> saveStack;
        private Stack<Integer> returnStack;

        public MyQueue() {
            saveStack = new Stack<>();
            returnStack = new Stack<>();
        }

        public void push(int x) {
            saveStack.push(x);
        }

        public int pop() {
            if ( returnStack.isEmpty() ) {
                while ( !saveStack.isEmpty() ) {
                    returnStack.push(saveStack.pop());
                }
                return returnStack.pop();
            } else {
                return returnStack.pop();
            }
        }

        public int peek() {
            if ( returnStack.isEmpty() ) {
                while ( !saveStack.isEmpty() ) {
                    returnStack.push(saveStack.pop());
                }
                return returnStack.peek();
            } else {
                return returnStack.peek();
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
