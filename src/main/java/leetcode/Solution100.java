package leetcode;

public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return reculsive(p,q);
    }

    private boolean reculsive(TreeNode p, TreeNode q) {
        if ( p == null ) {
            return q == null;
        }
        if ( q == null ) {
            return false;
        }
        if ( p.val != q.val ) {
            return false;
        }
        return reculsive(p.left, q.left) && reculsive(p.right, q.right);
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

