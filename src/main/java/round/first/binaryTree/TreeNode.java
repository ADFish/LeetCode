package round.first.binaryTree;

public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
        this.left = this.right = null;
    }


    //Preorder
    public void add(TreeNode root,int[] values){
        for (int i = 0; i < values.length; i++) {
            root = addRecursive(root, values[i]);
        }
    }

    private static TreeNode addRecursive(TreeNode current, int value){
        if(current == null){
            return new TreeNode(value);
        }else if(current.left == null){
            current.left = addRecursive(current.left , value);
        }else{
            current.right = addRecursive(current.right, value);
        }

        return current;
    }
}
