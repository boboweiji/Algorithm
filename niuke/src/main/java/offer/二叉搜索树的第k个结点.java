package offer;

import java.util.LinkedList;
import java.util.Stack;

public class 二叉搜索树的第k个结点 {

    static LinkedList<TreeNode> list = new LinkedList<>();

    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null){
            return null;
        } else {
            insert(list,pRoot);
            int size = list.size();
            if(k>size || k<1)
                return null;
            return list.get(k-1);
        }
    }

    static void insert(LinkedList<TreeNode> list, TreeNode pRoot){
        if(pRoot == null) return;
        if(pRoot.left == null){
            list.addLast(pRoot);
            insert(list,pRoot.right);
        } else {
            insert(list,pRoot.left);
            list.addLast(pRoot);
            insert(list,pRoot.right);
        }
    }

    // 非递归中序
    TreeNode KthNode_nb(TreeNode root, int k){
        if(root==null||k==0)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count = 0;
        TreeNode node = root;
        do{
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                count++;
                if(count==k)
                    return node;
                node = node.right;
            }
        }while(node!=null||!stack.isEmpty());
        return null;
    }

    public static void main(String[] args) {
        Integer[] array = {5,3,7,2,4,6,8};
        TreeNode treeNode = TreeNode.createBinaryTreeByArray(array,0);
        TreeNode result = KthNode(treeNode, 3);
        System.out.println(result.val);
    }

}
