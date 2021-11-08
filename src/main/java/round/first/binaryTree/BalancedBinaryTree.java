package round.first.binaryTree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 *
 * @see <a href="https://www.lintcode.com/problem/balanced-binary-tree/description">Original problem</a>
 */
public class BalancedBinaryTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    System.out.println(isBalanced(root));
    System.out.println(isBalanced2(root));

  }

  public static boolean isBalanced(TreeNode root) {
    // write your code here
    return maxDepth(root) != -1;
  }

  private static int maxDepth(TreeNode root){
    if(root == null){
      return 0;
    }

    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);

    if(leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1){
      return -1;
    }

    return Math.max(leftDepth, rightDepth);
  }

  public static boolean isBalanced2(TreeNode root){
    return helper(root).isBalanced;
  }

  private static ResultType helper(TreeNode root){
    if(root == null){
      return new ResultType(true, 0);
    }

    ResultType left = helper(root.left);
    ResultType right = helper(root.right);

    if(left.isBalanced == false || right.isBalanced == false || Math.abs(left.maxDepth - right.maxDepth) > 1){
      return new ResultType(false, Math.max(left.maxDepth, right.maxDepth) + 1);
    }

    return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
  }

}

class ResultType {
  public boolean isBalanced;
  public int maxDepth;
  public ResultType(boolean isBalanced, int maxDepth) {
    this.isBalanced = isBalanced;
    this.maxDepth = maxDepth;
  }
}
