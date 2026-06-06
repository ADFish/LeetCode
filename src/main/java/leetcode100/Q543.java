package leetcode100;

import round.second.binaryTree.TreeNode;

public class Q543 {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        heightHelper(root);
        return max;

    }

    private int heightHelper(TreeNode root) {
        if (root == null) return 0;
        int left = heightHelper(root.left);
        int right = heightHelper(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
