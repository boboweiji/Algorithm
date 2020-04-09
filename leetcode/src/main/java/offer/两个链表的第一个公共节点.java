package offer;

import java.util.HashSet;
import java.util.Set;

public class 两个链表的第一个公共节点 {

    //双指针法（顶子哥）
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a!=b){
            a = a==null?headB:a.next;
            b = b==null?headA:b.next;
        }
        return a;
    }

    //集合法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (true){
            if(headA != null) {
                if(set.contains(headA)){
                    return headA;
                }
                set.add(headA);
                headA = headA.next;
            } else if(headB != null) {
                if(set.contains(headB)){
                    return headB;
                }
                set.add(headB);
                headB = headB.next;
            } else {
                return null;
            }
        }
    }
}
