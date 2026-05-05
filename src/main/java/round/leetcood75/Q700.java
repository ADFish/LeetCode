package round.leetcood75;

import round.second.binaryTree.TreeNode;

public class Q700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val < val) {
            return searchBST(root.right, val);
        } else return searchBST(root.left, val);
    }

}
