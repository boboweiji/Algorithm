package offer;

public class 序列化二叉树 {

    int index = 0;

    String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        } else {
            return String.valueOf(root.val) + "!" + Serialize(root.left) + "!" + Serialize(root.right);
        }
    }

    TreeNode Deserialize(String str) {
        String[] s = str.split("!");
        if(s[index].equals("#")){
            index++;
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(s[index]));
            index++;
            root.left = Deserialize(str);
            root.right = Deserialize(str);
            return root;
        }
    }

}
