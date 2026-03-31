package dailyPractice.jianzhi;

public class Q1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) return 0;
        int count = 0;
        if (node.val >= max) {
            max = node.val;
            count = 1;
        }

        count += dfs(node.left, max);
        count += dfs(node.right,max);

        return count;
    }

}
