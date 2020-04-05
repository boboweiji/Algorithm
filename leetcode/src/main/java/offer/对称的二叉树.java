package offer;

public class 对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        else {
            return isSymmetric(root.left,root.right);
        }
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        boolean flag = true;
        if (left==null && right == null)
            flag = true;
        else if(left!=null && right == null)
            flag = false;
        else if (left == null && right != null)
            flag = false;
        else if (left.val != right.val)
            flag = false;
        else
            flag = isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        return flag;
    }
}
