package offer;

public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return left-right>=-1&&left-right<=1&&isBalanced(root.left)&&isBalanced(root.right);
        }
    }
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        else
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
