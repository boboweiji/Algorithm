package offer;

public class 二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        else {
            TreeNode result = new TreeNode(root.val);
            result.right = mirrorTree(root.left);
            result.left = mirrorTree(root.right);
            return result;
        }
    }
}
