package leetcode100;

import round.second.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalHelper(root, res);
        return res;
    }

    private void inorderTraversalHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorderTraversalHelper(root.left, res);
        res.add(root.val);
        inorderTraversalHelper(root.right, res);
    }
}
