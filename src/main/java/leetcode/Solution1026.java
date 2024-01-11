package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution1026 {

    private int max;

    public int maxAncestorDiff(TreeNode root) {
        max = 0;
        Set<TreeNode> set = new HashSet<>();
        set.add(root);

        leftRight(root.left, set);
        leftRight(root.right, set);
        return max;
    }

    private void leftRight(TreeNode node, Set<TreeNode> set) {
        if ( node == null ) {
            return;
        }

        for (TreeNode treeNode : set) {
            int v = Math.abs(treeNode.val - node.val);
            if ( v > max ) {
                max = v;
            }
        }
        set.add(node);
        if ( node.left != null ) {
            leftRight(node.left, set);
        }
        if ( node.right != null ) {
            leftRight(node.right, set);
        }
        set.remove(node);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}