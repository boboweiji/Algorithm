package offer;

public class 数值的整数次方 {
    // 暴力
    public double myPow(double x, int n) {
        double result = 1d;
        if(n<0){
            x = 1/x;
            n = -n;
        }
        for(int i = 0; i<n; i++){
            result *= x;
        }
        return result;
    }

    // 快速幂
    public static double myPow1(double x, int n) {
        double result = 1d;
        if(n<0){
            x = 1/x;
        }
        while (n!=0){
            if(n%2 == 1||n%2 == -1){
                result *=  x;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        myPow1(2.00000,-2147483647);
    }
}
