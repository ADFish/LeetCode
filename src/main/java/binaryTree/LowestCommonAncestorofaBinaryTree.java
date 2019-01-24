package binaryTree;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 *
 * @see <a href="https://www.lintcode.com/problem/lowest-common-ancestor-of-a-binary-tree/description">Original problem</a>
 */
public class LowestCommonAncestorofaBinaryTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    LowestCommonAncestorofaBinaryTree lcaGetter = new LowestCommonAncestorofaBinaryTree();
    TreeNode lca = lcaGetter.lowestCommonAncestor(root, root.left.left, root.left.right);
    System.out.println(lca.val);

    TreeNode lca2 = lcaGetter.findLCA(root, root.left.left, root.left.right);
    System.out.println(lca2.val);

  }

  //Method1: Without parent pointer
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    // write your code here
    ArrayList<TreeNode> path1 = new ArrayList<>();
    ArrayList<TreeNode> path2 = new ArrayList<>();
    findPath(root, A.val, path1);
    findPath(root, B.val, path2);

    if (path1 == null || path2 == null) {
      return null;
    }

    return findLCAinPathList(path1,path2);
  }

  /**
   * @param root A binary tree
   * @param N    node to be find in the tree
   * @param path Find the path to the node
   * @return
   */
  private static boolean findPath(TreeNode root, int N, ArrayList<TreeNode> path) {

    if (root == null) {
      return false;
    }

    path.add(root);

    if (root.val == N) {
      return true;
    }

    if (root.left != null && findPath(root.left, N, path)) {
      return true;
    }

    if (root.right != null && findPath(root.right, N, path)) {
      return true;
    }

    path.remove(path.size() - 1);
    return false;
  }

  private static TreeNode findLCAinPathList(ArrayList<TreeNode> path1, ArrayList<TreeNode> path2) {
    TreeNode ca = null;
    for (int i = 0; i < path1.size() && i < path2.size(); i++) {
      if (path1.get(i).equals(path2.get(i))) {
        ca = path1.get(i);
      }
    }
    return ca;
  }

  /**Method2: Without parent pointer, Suppose both node exist in the binary tree
   * The method 1 finds LCA in O(n) time, but requires three tree traversals plus extra spaces for path arrays.
   * If we assume that the keys n1 and n2 are present in Binary Tree,
   * we can find LCA using single traversal of Binary Tree and without extra storage for path arrays.
   */

  public TreeNode findLCA(TreeNode root, TreeNode A, TreeNode B){
    if(root == null){
      return null;
    }

    if(root.val == A.val || root.val == B.val){
      return root;
    }

    TreeNode leftLCA = findLCA(root.left, A, B);
    TreeNode rightLCA = findLCA(root.right, A, B);

    if(leftLCA != null && rightLCA != null){
      return root;
    }

    return (leftLCA != null) ? leftLCA : rightLCA;
  }

  /**
   * Method3: With parent pointer
   */

  
}

