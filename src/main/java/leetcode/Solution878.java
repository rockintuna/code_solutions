package leetcode;

public class Solution878 {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode node = head;

        while ( node != null ) {
            length += 1;
            node = node.next;
        }

        int middle = length/2 + 1;

        node = head;
        for (int i = 1; i < middle; i++) {
            node = node.next;
        }
        return node;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
