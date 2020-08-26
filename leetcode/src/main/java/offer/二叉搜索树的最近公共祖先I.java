package offer;

public class 二叉搜索树的最近公共祖先I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            if (p.val<root.val&&q.val<root.val){
                root = root.left;
            }
            else if(p.val>root.val&&q.val>root.val){
                root = root.right;
            } else {
                break;
            }
        }

        return root;
    }
}
