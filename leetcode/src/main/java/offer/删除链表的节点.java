package offer;

public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val)
            head = head.next;
        else {
            ListNode p = head;
            while (p!=null){
                if(p.next!=null&&p.next.val==val){
                    p.next = p.next.next;
                    break;
                }
                p = p.next;
            }
        }
        return head;
    }
}
