package offer;
class ZNode {
    public int val;
    public ZNode left;
    public ZNode right;

    public ZNode() {}

    public ZNode(int _val) {
        val = _val;
    }

    public ZNode(int _val,ZNode _left,ZNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class 二叉搜索树与双向链表 {
    ZNode pre, head;
    public ZNode treeToDoublyList(ZNode root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(ZNode cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
