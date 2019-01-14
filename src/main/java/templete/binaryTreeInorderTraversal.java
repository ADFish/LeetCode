package templete;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreeInorderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        int[] values = {2,4,5,3};
        root.add(root, values);

    }

    public static List<Integer> nonRecursion(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return result;
        }

        stack.add(root);
        while(!stack.isEmpty()){
            if()
        }

        return result;
    }

}
