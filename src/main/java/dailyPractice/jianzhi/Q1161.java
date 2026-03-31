package dailyPractice.jianzhi;

import java.util.ArrayList;
import java.util.List;

public class Q1161 {
    public int maxLevelSum(TreeNode root) {
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        int resLevel = 1;
        int sum = Integer.MIN_VALUE;

        for (int level = 1; !cur.isEmpty(); level++) {
            List<TreeNode> temp = cur;
            cur = new ArrayList<>();
            int tempSum = 0;

            for (TreeNode node : temp) {
                tempSum += node.val;
                if (node.left != null) {
                    cur.add(node.left);
                }
                if (node.right != null) {
                    cur.add(node.right);
                }
            }

            if (tempSum > sum) {
                sum = tempSum;
                resLevel = level;
            }
        }

        return resLevel;
    }
}
