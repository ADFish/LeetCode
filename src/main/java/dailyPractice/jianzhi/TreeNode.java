package dailyPractice.jianzhi;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void printTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        System.out.println(result);
    }

    private static void traverse(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}


