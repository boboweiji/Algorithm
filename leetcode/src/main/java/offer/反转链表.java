package offer;

public class 反转链表 {
    // 头插法
    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode next = head;
        while (head!=null){
            next = head.next;
            head.next = result.next;
            result.next = head;
            head = next;
        }
        return result.next;
    }
}
