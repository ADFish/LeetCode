package round.first.binaryTree;

/**
 * Given a binary tree, find the maximum path sum from root.
 * The path may end at any node in the tree and contain at least one node in it.
 *
 * @see <a href="https://www.lintcode.com/problem/binary-tree-maximum-path-sum-ii/description">description</a>
 */
public class BinaryTreeMaximumPathSum2 {

    /**
     * @param root: the root of binary tree.
     * @return: An integer
     */
    public int maxPathSum2(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }

        int leftPathSum = maxPathSum2(root.left);
        int rightPathSum = maxPathSum2(root.right);

        if(Math.max(leftPathSum, rightPathSum) > 0){
            return Math.max(leftPathSum, rightPathSum) + root.val;
        }else {
            return root.val;
        }
    }
}
