package string;

public class Solution91 {
    public static int numDecodings(String s) {
        int n = s.length();
        if(n==0 || s.startsWith("0"))
            return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1;i<n;i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1) != '1' && s.charAt(i-1) != '2'){
                    return 0;
                } else {
                    if(i>1){
                        dp[i] = dp[i-2];
                    }
                    else {
                        dp[i] = 1;
                    }
                }
            } else {
                int temp = (s.charAt(i-1)-'0')*10+s.charAt(i)-'0';
                if(temp>9&&temp<27){
                    if(i>1){
                        dp[i] = dp[i-2]+dp[i-1];
                    }else {
                        dp[i] = 2;
                    }
                }  else {
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("10"));
    }
}
