package offer;

import java.util.Stack;

public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        if(head==null){
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] result = new int[size];
        for(int i=0; i<size; i++){
            result[i] = stack.pop();
        }
        return result;
    }
}
