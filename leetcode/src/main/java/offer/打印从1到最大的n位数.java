package offer;

public class 打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int max = 1;
        int a = 10;
        while(n>0){
            if(n%2 == 1){
                max *= a;
            }
            a *= a;
            n /= 2;
        }
        int[] result = new int[--max];
        for(int i=1;i<=max;i++){
            result[i-1] = i;
        }
        return result;
    }
}
