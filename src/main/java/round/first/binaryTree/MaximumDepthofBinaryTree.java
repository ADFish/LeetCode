package round.first.binaryTree;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * @see <a href="https://www.lintcode.com/problem/maximum-depth-of-binary-tree/description">Original problem</a>
 */
public class MaximumDepthofBinaryTree {
  private static int deepth = 0;

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    System.out.println(maxDepth(root));
    System.out.println(maxDepthTraverse(root));
  }

  public static int maxDepth(TreeNode root) {
    // write your code here
    int result = 0;
    if (root == null) {
      return result;
    }

    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);

    return Math.max(leftDepth, rightDepth) + 1;

  }

  public static int maxDepthTraverse(TreeNode root) {
    helper(root, 1);
    return deepth;
  }

  private static void helper(TreeNode node, int currentDepth) {
    if (node == null) {
      return;
    }

    if (deepth < currentDepth) {
      deepth = currentDepth;
    }

    helper(node.left, currentDepth + 1);
    helper(node.right, currentDepth + 1);

  }
}
