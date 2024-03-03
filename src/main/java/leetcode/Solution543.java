package leetcode;

public class Solution543 {

    public int diameterOfBinaryTree(TreeNode root) {
        int countOfNodes = countNode(root);

        int[] a = new int[30];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        for (int i = 3; i < 30; i++) {
            a[i] = a[i-2] * 2;
        }
        for (int i = 0; i < a.length; i++) {
            if ( a[i] > countOfNodes ) {
                return a[i]-1;
            }
        }
        return a[30];
    }

    private int countNode(TreeNode root) {
        if ( root == null ) {
            return 0;
        }

        int i = 1;

        return i + countNode(root.left) + countNode(root.right);
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

