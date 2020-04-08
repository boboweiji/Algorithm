package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if(root==null)
            return new int[0];
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        list.addLast(root);
        while (!list.isEmpty()){
            TreeNode cur = list.removeFirst();
            result.add(cur.val);
            if(cur.left!=null) list.addLast(cur.left);
            if(cur.right!=null) list.addLast(cur.right);
        }
        int[] res = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }
}
