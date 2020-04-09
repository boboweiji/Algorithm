package offer;

public class 二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        else
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
