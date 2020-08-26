import java.util.Scanner;

public class 度小满_传送门 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int a[] = new int[N+1];
        for(int i=1; i<=N; i++){
            a[i] = in.nextInt();
        }
        int dp[] = new int[N+1];
        for(int i=1; i<N; i++) {
            if(dp[a[i]]!=0)
                dp[a[i]] = Math.min(dp[a[i]],dp[i]+A);
            else {
                dp[a[i]] = dp[i]+A;
            }
            if(a[i]>1){
                if(dp[a[i]-1] != 0)
                    dp[a[i]-1] = Math.min(dp[a[i]-1],dp[i]+B+A);
                else {
                    dp[a[i]-1] = dp[i]+B+A;
                }
            }
            if(a[i]<N){
                if(dp[a[i]+1] != 0)
                    dp[a[i]+1] = Math.min(dp[a[i]+1],dp[i]+C+A);
                else {
                    dp[a[i]+1] = dp[i]+C+A;
                }
            }
        }
        System.out.println(dp[N]);
    }
}
