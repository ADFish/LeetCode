package round.first.binaryTree.binarySearchTree;
//https://www.lintcode.com/problem/validate-binary-search-tree/description

import round.first.binaryTree.TreeNode;

public class ValidateBinarySearchTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(100);

    ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
    boolean result = vbst.isValidBST(root);
    System.out.println(result);

  }

  /**
   * @param root: The root of binary tree.
   * @return: True if the binary tree is BST, or false
   */
  public boolean isValidBST(TreeNode root) {
    // write your code here
    return divideConquer(root).isBST;
  }

  //Method 1: Divide conquer and traverse, 有全局变量
  private boolean helper(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }

    if (root.val < min || root.val > max) {
      return false;
    }

    boolean leftResult = helper(root.left, min, root.val);
    boolean rightResult = helper(root.right, root.val, max);

    return leftResult && rightResult;
  }

  //Method 2 Divide conquer with result type

  private VBSResultType divideConquer(TreeNode root) {
    if (root == null) {
      return new VBSResultType(true);
    }

    VBSResultType leftResult = divideConquer(root.left);
    VBSResultType rightResult = divideConquer(root.right);

    if (!leftResult.isBST || !rightResult.isBST) {
      return new VBSResultType(false);
    }

    if (leftResult.maxValue != null && leftResult.maxValue.val >= root.val) {
      return new VBSResultType(false);
    }

    if (rightResult.minValue != null && rightResult.minValue.val <= root.val) {
      return new VBSResultType(false);
    }

    VBSResultType result = new VBSResultType(true);
    result.minValue = leftResult.minValue != null ? leftResult.minValue : root;
    result.maxValue = rightResult.maxValue != null ? rightResult.maxValue : root;

    return result;
  }


}

class VBSResultType {
  public TreeNode minValue, maxValue;
  public boolean isBST;

  public VBSResultType(boolean isBST) {
    this.isBST = isBST;
    this.maxValue = null;
    this.minValue = null;
  }
}


