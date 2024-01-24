package leetcode;

public class Solution1457 {

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

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] footPrintArray = new int[9];
        return dfs(root, footPrintArray);
    }

    private int dfs(TreeNode node, int[] footPrintArray) {
        if (node == null) {
            return 0;
        }

        footPrintArray[node.val] = footPrintArray[node.val] + 1;

        if (node.left == null && node.right == null) {
            int oddCount = countOdd(footPrintArray);
            footPrintArray[node.val] = footPrintArray[node.val] - 1;

            if ( oddCount <= 1 ) {
                return 1;
            } else {
                return 0;
            }
        }

        int count = 0;
        count += dfs(node.left, footPrintArray);
        count += dfs(node.right, footPrintArray);

        footPrintArray[node.val] = footPrintArray[node.val] - 1;

        return count;
    }

    private int countOdd(int[] footPrintArray) {
        int count = 0;
        for (int num : footPrintArray) {
            if (num % 2 == 1) {
                count++;
            }
        }
        return count;
    }
}
