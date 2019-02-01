package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.lintcode.com/problem/binary-tree-level-order-traversal/description
public class BinaryTreeLevelOrderTraversal {
  /**
   * @param root: A Tree
   * @return: Level order a list of lists of integer
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    // write your code here
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()){
      List<Integer> level = new ArrayList<>();
      int size = queue.size();// Very important, this should not be write in the for loop
      for (int i = 0; i < size; i++) {
        TreeNode head = queue.poll();
        level.add(head.val);

        if(head.left != null){
          queue.offer(head.left);
        }
        if(head.right != null){
          queue.offer(head.right);
        }
      }// End for loop
      result.add(level);
    }

    return result;
  }

}
