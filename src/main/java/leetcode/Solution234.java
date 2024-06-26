package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution234 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        for (int i = 0; i < list.size()/2; i++) {
            if ( !list.get(i).equals(list.get(list.size()-1-i)) ) {
                return false;
            }
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
