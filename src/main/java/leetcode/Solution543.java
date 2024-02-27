package leetcode;

public class Solution543 {

    public int diameterOfBinaryTree(TreeNode root) {
        getMaxPathLeng(root);
    }

    private void getMaxPathLeng(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;

        int leftLength = 1;
        int rightLength = 1;

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

