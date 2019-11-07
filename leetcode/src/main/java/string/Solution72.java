package string;

//编辑距离
public class Solution72 {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = m; i>=0; i--){
            for(int j = n; j>=0; j--){
                if(i==m&&j==n){
                    dp[i][j] = 0;
                } else if(i==m){
                    dp[i][j] = 1+dp[i][j+1];
                } else if(j==n){
                    dp[i][j] = 1+dp[i+1][j];
                }
                else {
                    if(word1.charAt(i) == word2.charAt(j)){
                        dp[i][j] = dp[i+1][j+1];
                    }else {
                        dp[i][j] = 1+Math.min(dp[i+1][j+1],Math.min(dp[i+1][j],dp[i][j+1]));
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("spartan","part"));
    }
}
