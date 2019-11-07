package string;

public class Solution67 {
    public static String addBinary(String a, String b) {
        int jinwei = 0;
        int i=a.length()-1,j=b.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i>=0&&j>=0){
            int sum = a.charAt(i)+b.charAt(j)-96+jinwei;
            sb.insert(0,sum%2);
            jinwei = sum/2;
            i--;
            j--;
        }
        while(i>=0){
            int sum = a.charAt(i)-48+jinwei;
            sb.insert(0,sum%2);
            jinwei = sum/2;
            i--;
        }
        while(j>=0){
            int sum = b.charAt(j)-48+jinwei;
            sb.insert(0,sum%2);
            jinwei = sum/2;
            j--;
        }
        if(jinwei>0)
            sb.insert(0,jinwei);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }
}
