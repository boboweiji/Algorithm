package string;

// 报数
public class Solution38 {

    public static String countAndSay(int n) {
        String res = "1";
        if(n == 1){
            return "1";
        }
        for(int i=2; i<=n; i++){
            StringBuilder cur = new StringBuilder();
            int j = 0;
            while (j<res.length()){
                if(j==res.length()-1){
                    cur.append('1').append(res.charAt(j));
                    break;
                } else {
                    int count = 1;
                    while (j<res.length()-1 && (res.charAt(j) == res.charAt(j + 1))){
                        count++;
                        j++;
                    }
                    cur.append(count).append(res.charAt(j));
                    j++;
                }
            }
            res = cur.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

}
