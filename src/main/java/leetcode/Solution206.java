package leetcode;

import java.util.Stack;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if ( head == null ) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();

        ListNode node = head;
        while ( node != null ) {
            stack.push(node);
            node = node.next;
        }

        ListNode result = null;
        while ( !stack.isEmpty() ) {
            if ( node == null ) {
                result = stack.pop();
                node = result;
            } else {
                node.next = stack.pop();
                node = node.next;
            }
        }
        node.next = null;

        return result;
    }

    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}
