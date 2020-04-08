package offer;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int m = pushed.length;
        int n = popped.length;
        int indexm = 0;
        int indexn = 0;
        while (indexm<m&&indexn<n){
            if(popped[indexn] == pushed[indexm]){
                ++indexm;
                ++indexn;
                continue;
            }
            else {
                if(!stack.isEmpty()&&popped[indexn]==stack.peek()){
                    ++indexn;
                    stack.pop();
                } else {
                    stack.push(pushed[indexm++]);
                }
            }
        }
        while (indexn<n){
            if(popped[indexn]!=stack.peek()){
                return false;
            } else {
                stack.pop();
                indexn++;
            }
        }
        return stack.isEmpty()?true:false;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] poped = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed,poped));
    }
}
