package offer;

public class 圆圈中最后剩下的数字 {
    // 超时
    public static int lastRemaining(int n, int m) {
        int[] arr = new int[n];
        int index = 0;
        for(int i=0;i<n-1;i++){
            int j = 0;
            while (j<m){
                if(arr[index]==0){
                    j++;
                    if(j==m)
                        arr[index] = -1;
                    index = (index+1)%n;
                } else {
                    index = (index+1)%n;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]==0)
                return i;
        }
        return 0;
    }

    public static int lastRemaining1(int n, int m){
        int flag = 0;
        for (int i = 2; i <= n; i++) {
            flag = (flag + m) % i;
            //动态规划的思想，将f(n,m)替换成flag存储
        }
        return flag;
    }

    public static void main(String[] args) {
        lastRemaining(5,1);
    }
}
