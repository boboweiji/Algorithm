import java.util.Scanner;

public class 美团_小美的仓库整理 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] weight = new int[m];
        int[] seq = new int[m];
        int[] dp = new int[m];
        int[] result = new int[m];
        int left = 0,right=0;
        for (int i = 0; i < m; i++) {
            int n = scanner.nextInt();
            weight[i] = n;
            if (i == 0) dp[i] = n;
            else {
                dp[i] = dp[i - 1] + n;
            }
        }
        for (int i = 0; i < m; i++) {
            int n = scanner.nextInt();
            seq[i] = n - 1;
        }
        for (int i = 0; i < m; i++) {
            if(i==0){
                for (int j = 0; j < seq[i]; j++) {
                    left += weight[j];
                }
                for (int j = seq[i]+1; j < m; j++) {
                    right += weight[j];
                }

            } else {
                int change = 0;
                if(seq[i]>seq[i-1]){
                    for(int j=seq[i-1]+1;j<seq[i];j++){
                        change += weight[j];
                    }
                    right -= (change+weight[seq[i]]);
                    left  += change;
                } else {
                    for(int j=seq[i]+1;j<seq[i-1];j++){
                        change += weight[j];
                    }
                    left -= (change+weight[seq[i]]);
                    right  += change;
                }
            }
            weight[seq[i]] = 0;
            result[i] = Math.max(left, right);
        }
        for (int i = 0; i < m; i++) {
            if(i==m-1){
                System.out.println(result[i]);
            } else
                System.out.print(result[i]+" ");
        }
    }
}
