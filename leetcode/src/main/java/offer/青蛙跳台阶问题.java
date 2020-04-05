package offer;

public class 青蛙跳台阶问题 {
    // dp
    public int numWays(int n) {
        if(n<2)
            return 1;
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for(int i=2;i<n;i++){
            result[i] = (result[i-2]+result[i-1])%1000000007;
        }
        return result[n-1];
    }
}
