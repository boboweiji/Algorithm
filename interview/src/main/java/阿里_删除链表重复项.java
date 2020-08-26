class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class 阿里_删除链表重复项 {
    public static ListNode solution(ListNode head){
        if(head.next==null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null){
            while (fast != null && fast.val == slow.val){
                fast =  fast.next;
            }
            slow.next = fast;
            if(fast!=null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        list.next = new ListNode(0);
        list.next.next = new ListNode(1);
        list.next.next.next = new ListNode(1);
        solution(list);
    }
}
