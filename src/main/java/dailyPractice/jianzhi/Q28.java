package dailyPractice.jianzhi;

public class Q28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        else return recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        return recur(left.left, right.right) && recur(left.right, right.left);
    }

}
