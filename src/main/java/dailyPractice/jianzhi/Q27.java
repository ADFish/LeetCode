package dailyPractice.jianzhi;

public class Q27 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode.printTree(root);

        Q27 q27 = new Q27();
        TreeNode result = q27.mirrorTree(root);
        TreeNode.printTree(result);

    }

    public TreeNode mirrorTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root.left != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        } else return;

        traverse(root.left);
        traverse(root.right);

    }
}
