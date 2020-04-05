package offer;

public class 斐波那契数列 {
    // 递归版，超时
    public int fib(int n) {
        if(n<2){
            return n;
        } else {
            return (fib(n-2) + fib(n-1))%1000000007;
        }
    }

    // 迭代版
    public int fib1(int n) {
        if(n<2){
            return n;
        } else {
            int one = 0;
            int two = 1;
            int index = 2;
            while (index<n){
                int sum = (one+two)%1000000007;
                one = two;
                two = sum;
                index++;
            }
            return (one+two)%1000000007;
        }
    }
}
