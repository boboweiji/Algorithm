package string;

// z字形变换
public class Solution6 {
    public static String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int[] arr = new int[s.length()];
        char[] c = new char[s.length()];
        for(int i=0;i<s.length();i++){
            int yu = i%(2*numRows-2);
            if(yu<numRows){
                arr[i] = yu;
            }else{
                arr[i] = 2*numRows-yu-2;
            }
        }
        int k = 0;
        for(int j=0;j<numRows;j++){
            for(int i=0;i<s.length();i++){
                if(arr[i]==j){
                    c[k] = s.charAt(i);
                    k++;
                }
            }
        }
        String str = new String(c);
        return str;
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int n = 4;
        System.out.println(convert(s,n));
    }
}
