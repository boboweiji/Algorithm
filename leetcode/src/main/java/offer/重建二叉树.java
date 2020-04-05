package offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 重建二叉树 {

    // 递归
    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int prestart, int preend,
                              int[] inorder, int instart, int inend,
                              Map<Integer,Integer> map){
        if(preend<prestart)
            return null;
        if(preend == prestart){
            return new TreeNode(preorder[prestart]);
        } else {
            TreeNode root = new TreeNode(preorder[prestart]);
            int index = map.get(preorder[prestart]);
            int nextPreIndex = prestart+1;
            int nextInIndex = prestart;
            for(int i=nextPreIndex;i<preorder.length&&map.get(preorder[i])<index;i++){
                nextInIndex = i;
            }
            root.left = buildTree(preorder,nextPreIndex,nextInIndex,inorder,instart,index-1,map);
            root.right = buildTree(preorder,nextInIndex+1,preend,inorder,index+1,inend,map);
            return root;
        }
    }

    // 迭代
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int size = preorder.length;
        int indexi = 0;
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for(int i=1;i<size;i++){
            TreeNode cur = stack.peek();
            if(cur.val != inorder[indexi]){
                TreeNode nextLeft = new TreeNode(preorder[i]);
                cur.left = nextLeft;
                stack.push(nextLeft);
            } else {
                while (stack.size()!=0&&stack.peek().val==inorder[indexi]){
                    cur = stack.pop();
                    indexi++;
                }
                TreeNode nextRight = new TreeNode(preorder[i]);
                cur.right = nextRight;
                stack.push(nextRight);
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        int[] preorder = new int[]{3,9,20,15,7};
//        int[] inorder = new int[]{9,3,15,20,7};
        int[] preorder = new int[]{1,2};
        int[] inorder = new int[]{1,2};
        //TreeNode root = buildTree1(preorder,inorder);
        TreeNode root = buildTree2(preorder,inorder);
        System.out.println(root.val);
    }
}
