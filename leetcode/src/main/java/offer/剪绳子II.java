package offer;

public class 剪绳子II {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3-1, b = n % 3;
        // 快速幂logN
        long xishu = 1; //系数
        long dishu = 3; //底数
        for(; a>0 ; a/=2){
            if(a%2 == 1){
                xishu = (xishu * dishu)%1000000007;
            }
            dishu = (dishu*dishu)%1000000007;
        }
        if(b == 0) return (int)(xishu*3)%1000000007;
        if(b == 1) return (int)(xishu*4)%1000000007;
        return (int)(xishu*6)%1000000007;
    }
}
