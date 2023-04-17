package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        reculsive(root, results);
        return results;
    }

    private void reculsive(TreeNode node, List<Integer> results) {
        results.add(node.val);
        if ( node.left != null ) {
            reculsive(node.left, results);
        }
        if ( node.right != null ) {
            reculsive(node.right, results);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2, treeNode4, null);
        TreeNode treeNode = new TreeNode(1, null, treeNode3);
        Solution144 test = new Solution144();
        System.out.println(test.preorderTraversal(treeNode));
    }
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
