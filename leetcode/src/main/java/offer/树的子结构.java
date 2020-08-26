package offer;

public class 树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (digui(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean digui(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return digui(A.left, B.left) && digui(A.right, B.right);
    }
}
