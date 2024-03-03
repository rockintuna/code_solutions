package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1609 {

    public boolean isEvenOddTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        boolean evenIndexedLevel = true;
        while ( !stack.isEmpty() ) {
            List<TreeNode> list = new ArrayList<>();
            while ( !stack.isEmpty() ) {
                TreeNode treeNode = stack.pop();
                if ( evenIndexedLevel && !isEven(treeNode.val) ) {
                    list.add(treeNode);
                } else if ( !evenIndexedLevel && isEven(treeNode.val) ) {
                    list.add(treeNode);
                } else {
                    return false;
                }
            }

            if ( !inIncreasingOrder(list, stack, evenIndexedLevel) ) {
                return false;
            }
            evenIndexedLevel = !evenIndexedLevel;
        }
        return true;
    }

    private boolean inIncreasingOrder(List<TreeNode> list, Stack<TreeNode> stack, boolean evenIndexedLevel) {
        int value = 0;
        for (TreeNode treeNode : list) {
            if (value < treeNode.val) {
                if (evenIndexedLevel) {
                    if (treeNode.left != null) {
                        stack.push(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        stack.push(treeNode.right);
                    }
                } else {
                    if (treeNode.right != null) {
                        stack.push(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        stack.push(treeNode.left);
                    }
                }
                value = treeNode.val;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isEven(int value) {
        return value%2 == 0;
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

