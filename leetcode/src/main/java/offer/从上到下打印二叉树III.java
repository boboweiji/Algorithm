package offer;

import java.util.*;

public class 从上到下打印二叉树III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int level = 1;
        while (!stack.isEmpty()){
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack1 = new Stack<>();
            for(int i=stack.size();i>0;i--){
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if(level%2==1){
                    if(cur.left!=null) stack1.push(cur.left);
                    if(cur.right!=null) stack1.push(cur.right);
                } else {
                    if(cur.right!=null) stack1.push(cur.right);
                    if(cur.left!=null) stack1.push(cur.left);
                }
            }
            level++;
            result.add(res);
            stack = stack1;
        }
        return result;
    }

    // bfs+倒序
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }
}
