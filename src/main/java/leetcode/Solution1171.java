package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();

        ListNode newHead = new ListNode(0, head);

        int sum = 0;
        ListNode node = newHead;
        while (node != null) {
            sum += node.val;
            map.put(sum, node);
            node = node.next;
        }

        sum = 0;
        node = newHead;
        while (node != null) {
            sum += node.val;
            node.next = map.get(sum).next;
            node = node.next;
        }

        return newHead.next;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
