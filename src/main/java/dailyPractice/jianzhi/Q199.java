package dailyPractice.jianzhi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);

        while (!cur.isEmpty()) {
            res.add(cur.get(0).val);
            List<TreeNode> temp = cur;
            cur = new ArrayList<>();

            for (TreeNode node : temp) {
                if(node.right != null) {
                    cur.add(node.right);
                }
                if(node.left != null) {
                    cur.add(node.left);
                }
            }
        }

        return res;
    }
}
