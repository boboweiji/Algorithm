package offer;

import java.util.ArrayList;

public class 按之字形顺序打印二叉树 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot==null){
            return result;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(pRoot);
        for(int i = 1;;i++){
            ArrayList<TreeNode> treeList = new ArrayList<>();
            ArrayList<Integer> intList = new ArrayList<>();
            if(i%2==1) {
                for(int j=list.size()-1;j>=0;j--){
                    TreeNode treeNode = list.get(j);
                    intList.add(treeNode.val);
                    if (treeNode.left != null)
                        treeList.add(treeNode.left);
                    if (treeNode.right != null)
                        treeList.add(treeNode.right);
                }
                result.add(intList);
                if (treeList.size() == 0) break;
                else list = treeList;
            } else {
                for(int j=list.size()-1;j>=0;j--){
                    TreeNode treeNode = list.get(j);
                    intList.add(treeNode.val);
                    if (treeNode.right != null)
                        treeList.add(treeNode.right);
                    if (treeNode.left != null)
                        treeList.add(treeNode.left);
                }
                result.add(intList);
                if (treeList.size() == 0) break;
                else list = treeList;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] array = {8,6,10,5,7,9,11};
        TreeNode treeNode = TreeNode.createBinaryTreeByArray(array,0);
        ArrayList<ArrayList<Integer>> arrayLists = Print(treeNode);
        System.out.println(arrayLists);
    }
}
