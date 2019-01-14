package templete;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreeInorderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(nonRecursion(root));

        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        System.out.println(result);

        System.out.println(divideConquer(root));

    }

    public static List<Integer> nonRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            result.add(node.val);

            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

        }

        return result;
    }

    public static void traverse(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }

        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }

    public static ArrayList<Integer> divideConquer(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        ArrayList<Integer> leftResult = divideConquer(root.left);
        ArrayList<Integer> rightResult = divideConquer(root.right);

        result.addAll(leftResult);
        result.add(root.val);
        result.addAll(rightResult);

        return result;
    }
}

