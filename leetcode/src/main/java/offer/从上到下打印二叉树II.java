package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 从上到下打印二叉树II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        int index = 1;
        while (!list.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int newIndex = 0;
            for(int i = 0; i<index; i++){
                TreeNode cur = list.removeFirst();
                level.add(cur.val);
                if(cur.left!=null) {
                    list.addLast(cur.left);
                    newIndex++;
                }
                if(cur.right!=null) {
                    list.addLast(cur.right);
                    newIndex++;
                }
            }
            result.add(level);
            index = newIndex;
        }
        return result;
    }
}
