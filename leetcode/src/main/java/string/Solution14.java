package string;

//最长公共前缀
public class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
        /*if (strs.length == 0) {
            return "";
        }*/
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        int count = 0;
        while(flag){
            char c;
            if(strs.length == 0 || strs[0].length()==count){
                break;
            }else{
                c = strs[0].charAt(count);
            }
            for(String s : strs){
                if(s.length()==count){
                    flag = false;
                    break;
                } else if (s.charAt(count) != c){
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append(c);
                count++;
            }
        }
        if(sb!=null){
            return sb.toString();
        }else {
            return "";
        }
    }

    public static void main(String[] args) {
        String[] strs = {};
        System.out.println(longestCommonPrefix(strs));
    }
}
