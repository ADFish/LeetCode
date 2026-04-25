package round.leetcood75;


import round.second.binaryTree.TreeNode;

import java.util.ArrayList;

public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        findPath(root, p, path1);
        findPath(root, q, path2);

        if (path1 == null || path2 == null) return null;




        for (int i = path1.size() - 1; i >= 0; i--) {
            for (int j = path2.size() - 1; j >= 0; j--) {
                if (path1.get(i) == path2.get(j)) return path1.get(i);
            }
        }

        return null;
    }

    private boolean findPath(TreeNode root, TreeNode target, ArrayList<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root.val == target.val) return true;

        if (findPath(root.left, target, path) || findPath(root.right, target, path)) return true;

        path.remove(path.size() - 1);
        return false;
    }


}
