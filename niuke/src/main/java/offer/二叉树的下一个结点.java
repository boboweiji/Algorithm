package offer;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class 二叉树的下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null)
            return null;
        else if(pNode.right!=null)
            return getLeft(pNode.right);
        else{
            while (pNode.next != null && pNode.next.right == pNode){
                pNode = pNode.next;
            }
            return pNode.next;
        }

    }

    public TreeLinkNode getLeft(TreeLinkNode root){
        if(root.left == null){
            return root;
        } else {
            return getLeft(root.left);
        }
    }
}
