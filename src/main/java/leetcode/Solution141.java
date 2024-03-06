package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution141 {

     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

     public boolean hasCycle(ListNode head) {
         Set<ListNode> set = new HashSet<>();
         ListNode node = head;
         while ( node != null ) {
             if ( set.contains(node) ) {
                 return true;
             } else {
                 set.add(node);
             }
             node = node.next;
         }
         return false;
     }
}
