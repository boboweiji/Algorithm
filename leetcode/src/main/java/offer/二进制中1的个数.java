package offer;

public class 二进制中1的个数 {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            if((n&1) == 1){
                count++;
            }
            n = n>>>1; //无符号右移
        }
        return count;
    }

    //巧用 n & (n - 1)
    public static int hammingWeight1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(-1));
    }
}
