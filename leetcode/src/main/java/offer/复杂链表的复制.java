package offer;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class 复杂链表的复制 {
    // 哈希表
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        else {
            Map<Node,Node> map = new HashMap<>();
            for(Node cur=head; cur!=null; cur=cur.next){
                Node newNode = new Node(cur.val);
                map.put(cur,newNode);
            }
            for(Node cur=head; cur!=null; cur=cur.next){
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
            }
            return map.get(head);
        }
    }

    //迭代
    public Node copyRandomList1(Node head) {
        if(head == null)
            return null;
        //先复制，穿起来
        Node cur = head;
        while (cur != null){
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }

        //赋random节点
        cur = head;
        while (cur != null){
            if(cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //两个表分开
        Node head1 = head.next;
        cur = head;
        while (cur!=null){
            Node temp = cur.next;
            if(temp!=null){
                cur.next = temp.next;
            }
            cur = temp;
        }
        return head1;
    }
}
