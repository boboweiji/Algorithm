package offer;

public class 礼物的最大价值 {
    public static int maxValue(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0&&j==0){
                    dp[i][j] = grid[0][0];
                } else if(i==0){
                    dp[i][j] = dp[i][j-1]+grid[i][j];
                } else if(j==0){
                    dp[i][j] = dp[i-1][j]+grid[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1]+grid[i][j],dp[i-1][j]+grid[i][j]);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int grid[][] = {{1,2,3},{4,5,6}};
        maxValue(grid);
    }
}
