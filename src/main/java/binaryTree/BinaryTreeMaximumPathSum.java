package binaryTree;

import apple.laf.JRSUIUtils;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 *
 * @see <a href="https://www.lintcode.com/problem/binary-tree-maximum-path-sum/description">description</a>
 */
public class BinaryTreeMaximumPathSum {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(-15);
    root.left = new TreeNode(5);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(-8);
    root.left.right = new TreeNode(1);
    root.left.left.left = new TreeNode(2);
    root.left.left.right = new TreeNode(6);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(9);
    root.right.right.right = new TreeNode(0);
    root.right.right.right.left = new TreeNode(4);
    root.right.right.right.right = new TreeNode(-1);
    root.right.right.right.right.left = new TreeNode(10);

    BinaryTreeMaximumPathSum btmp = new BinaryTreeMaximumPathSum();
    int result = btmp.maxPathSum(root);
    System.out.println(result);

  }

  /**
   * @param root: The root of binary tree.
   * @return: An integer
   */
  public int maxPathSum(TreeNode root) {
    // write your code here
    ResultType2 result = helper(root);
    return result.any2any;
  }

  private static ResultType2 helper(TreeNode root) {
    if (root == null) {
      return new ResultType2(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    ResultType2 leftResult = helper(root.left);
    ResultType2 rightResult = helper(root.right);

    int root2any = root.val + Math.max(0, Math.max(leftResult.root2any, rightResult.root2any));
    int any2any = Math.max(leftResult.any2any, rightResult.any2any);
    any2any = Math.max(any2any, root.val + Math.max(0, leftResult.root2any) + Math.max(0, rightResult.root2any));

    return new ResultType2(root2any, any2any);
  }

}

class ResultType2 {
  int root2any, any2any;

  ResultType2(int root2any, int any2any) {
    this.root2any = root2any;
    this.any2any = any2any;
  }
}
