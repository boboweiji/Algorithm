package offer;

import java.util.LinkedList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        digui(root,sum);
        return res;
    }

    public void digui(TreeNode root, int sum){
        if(root == null)
            return;
        sum -= root.val;
        path.add(root.val);
        if(sum==0&&root.left==null&&root.right==null){
            res.add(new LinkedList<>(path));
        }
        digui(root.left,sum);
        digui(root.right,sum);
        path.removeLast();
    }
}
