package offer;

public class 构建乘积数组 {
    public static int[] multiply(int[] A) {
        int len = A.length;
        int B[] = new int[len];
        int num = 1;
        for(int i=0;i<len;i++){
            B[i] = num;
            num *= A[i];
        }
        num = 1;
        for(int i=len-1;i>=0;i--){
            B[i] = B[i]*num;
            num *= A[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int A[] = {1,2,3,4,5};
        multiply(A);
    }
}
