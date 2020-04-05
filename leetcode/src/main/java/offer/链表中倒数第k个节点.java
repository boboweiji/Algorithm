package offer;

public class 链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int size = 0;
        ListNode p = head;
        while (p!=null){
            size++;
            p = p.next;
        }
        for(int i=0; i<size-k; i++){
            head = head.next;
        }
        return head;
    }

    // 双指针
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode fast = head;
        ListNode result = head;
        for(int i=0; i<k; i++){
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            result = result.next;
        }
        return result;
    }
}
