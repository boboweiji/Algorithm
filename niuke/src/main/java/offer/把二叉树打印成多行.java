package offer;

import java.util.ArrayList;

public class 把二叉树打印成多行 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(pRoot);
        while (true) {
            ArrayList<TreeNode> treeList = new ArrayList<>();
            ArrayList<Integer> intList = new ArrayList<>();
            for (TreeNode treeNode : list) {
                intList.add(treeNode.val);
                if (treeNode.left != null)
                    treeList.add(treeNode.left);
                if (treeNode.right != null)
                    treeList.add(treeNode.right);
            }
            result.add(intList);
            if (treeList.size() == 0) break;
            else list = treeList;
        }
        return result;
    }
}
