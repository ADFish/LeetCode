package dailyPractice.jianzhi;
// https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/

import round.second.binaryTree.TreeNode;

import java.util.HashMap;

public class StarQ7 {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int pre_root_index, int in_left_index, int in_right_index) {
        if (in_left_index > in_right_index) return null;
        TreeNode root = new TreeNode(preorder[pre_root_index]);
        int in_root_index = map.get(preorder[pre_root_index]);
        root.left = recur(pre_root_index + 1, in_left_index, in_root_index - 1);
        root.right = recur(pre_root_index + (in_root_index - in_left_index) + 1, in_root_index + 1, in_right_index);
        return root;
    }
}