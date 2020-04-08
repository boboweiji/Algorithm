package offer;

import java.util.Stack;

public class 二叉搜索树的后序遍历序列 {
    public static boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder,0,postorder.length-1);
    }

    public static boolean verifyPostorder(int[] postorder, int start, int end) {
        if(start<=end){
            if(start==end)
                return true;
            else {
                int root = postorder[end];
                int index=start;
                while (index<=end && postorder[index]<root){
                    index++;
                }
                for(int i=index;i<end;i++){
                    if(postorder[i]<=root)
                        return false;
                }
                return verifyPostorder(postorder,start,index-1) && verifyPostorder(postorder,index,end-1);
            }
        }
        return true;
    }

    // 单调栈（顶子哥方法）
    public boolean verifyPostorder1(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] postorder = {1,3,2,6,5};
        System.out.println(verifyPostorder(postorder));
    }
}
