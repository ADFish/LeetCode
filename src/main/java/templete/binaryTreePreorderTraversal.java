package templete;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Challenge: Can you do it without recursion?
 *
 * @see <a href="https://www.lintcode.com/problem/binary-tree-preorder-traversal/description">Original problem</a>
 */
public class binaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        int[] values = {2,4,5,3};
        root.add(root, values);
/*        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);*/

        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        System.out.println(result.toString());

        System.out.println(dividConquer(root).toString());

        System.out.println(nonRecursion(root));
    }

    //Method 0 Non-Recursion method
    public static ArrayList<Integer> nonRecursion(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        stack.add(root);
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if(temp.right != null){
                stack.add(temp.right);
            }
            if(temp.left != null){
                stack.add(temp.left);
            }
        }

        return result;
    }

    //Method 1 traverse
    public static void traverse(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }

    //Method 2 Divide and Conquer
    public static ArrayList<Integer> dividConquer(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        ArrayList<Integer> leftResult = dividConquer(root.left);
        ArrayList<Integer> rightResult = dividConquer(root.right);

        result.add(root.val);
        result.addAll(leftResult);
        result.addAll(rightResult);

        return result;
    }
}
