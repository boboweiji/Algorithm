package offer;

public class 机器人的运动范围 {
    //dp
    public int movingCount(int m, int n, int k) {
        int cnt = 0;
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0){
                    if(j==0){
                        dp[i][j] = 1;
                        cnt++;
                    }
                    else{
                        if(sum(i,j) <= k && dp[i][j-1] == 1)
                            dp[i][j] =1;
                    }
                }

            }
        }
        return 0;
    }

    public int sum(int i,int j){
        int sum = 0;
        while (i!=0){
            sum += i%10;
            i /= 10;
        }
        while (j!=0){
            sum += j%10;
            j /= 10;
        }
        return sum;
    }
}
