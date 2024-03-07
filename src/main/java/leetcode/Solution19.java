package leetcode;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nMinusOneThNode = null;
        ListNode currentNode = head;
        int i = 1;

        while ( currentNode != null ) {
            if ( i == n + 1 ) {
                nMinusOneThNode = head;
            }
            if ( i > n + 1 ) {
                nMinusOneThNode = nMinusOneThNode.next;
            }
            i++;
            currentNode = currentNode.next;
        }

        if ( nMinusOneThNode == null ) {
            return head.next;
        } else {
            nMinusOneThNode.next = nMinusOneThNode.next.next != null ? nMinusOneThNode.next.next : null;
            return head;
        }
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
