package binaryTree.binarySearchTree;

import binaryTree.TreeNode;

import java.util.Stack;

public class BSTIterator {

  private Stack<TreeNode> stack = new Stack<>();
  /*
   * @param root: The root of binary tree.
   */
  public BSTIterator(TreeNode root) {
    // do intialization if necessary
    while (root != null){
      stack.add(root);
      root = root.left;
    }
  }

  /*
   * @return: True if there has next node, or false
   */
  public boolean hasNext() {
    // write your code here
    return !stack.isEmpty();
  }

  /*
   * @return: return next node
   */
  public TreeNode next() {
    // write your code here
    if(stack.isEmpty()){
      return null;
    }

    TreeNode curt = stack.pop();
    if(curt.right != null){
      TreeNode node = curt.right;
      while(node != null){
        stack.push(node);
        node = node.left;
      }
    }
    return curt;
  }

}
