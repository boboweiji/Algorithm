package offer;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树的第k大节点 {
    // 先中序遍历
    static List<Integer> list = new ArrayList<>();
    public static int kthLargest(TreeNode root, int k) {
        travel(root);
        return list.get(list.size()-k);
    }

    public static void travel(TreeNode root){
        if(root == null) {
            return;
        } else {
            travel(root.left);
            list.add(root.val);
            travel(root.right);
        }
    }

    static int m,res;
    public static int kthLargest1(TreeNode root, int k) {
        m = k;
        travel1(root);
        return res;
    }

    public static void travel1(TreeNode root){
        if(root == null) {
            return;
        } else {
            travel1(root.right);
            if(m==0)
                return;
            if(--m==0) res = root.val;
            travel1(root.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        root.left = t1;
        root.right = t4;
        t1.right = t2;
        System.out.println(kthLargest1(root,1));
    }
}
