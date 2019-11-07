package string;

public class Solution115 {
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0){
                    dp[i][j] = 1;
                }else if(j<i){
                    dp[i][j] = 0;
                }else if(s.charAt(j-1)!=t.charAt(i-1)){
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String S = "rabbbit", T = "rabbit";
        System.out.println(numDistinct(S,T));
    }
}
