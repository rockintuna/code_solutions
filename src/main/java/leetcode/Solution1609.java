package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1609 {

    public boolean isEvenOddTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        boolean evenIndexedLevel = true;
        while ( !list.isEmpty() ) {
            List<TreeNode> newList = new ArrayList<>();
            int value = 0;
            for (int i = 0; i < list.size(); i++) {
                TreeNode treeNode = list.get(i);
                if ( i == 0 ) {
                    if ( evenIndexedLevel ) {
                        if ( isEven(treeNode.val) ) {
                            return false;
                        }
                    } else {
                        if ( !isEven(treeNode.val) ) {
                            return false;
                        }
                    }
                } else {
                    if ( evenIndexedLevel ) {
                        if ( isEven(treeNode.val) || value >= treeNode.val  ) {
                            return false;
                        }
                    } else {
                        if ( !isEven(treeNode.val) || value <= treeNode.val ) {
                            return false;
                        }
                    }
                }
                value = treeNode.val;
                if ( treeNode.left != null ) {
                    newList.add(treeNode.left);
                }
                if ( treeNode.right != null ) {
                    newList.add(treeNode.right);
                }
            }
            list = newList;
            evenIndexedLevel = !evenIndexedLevel;
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

