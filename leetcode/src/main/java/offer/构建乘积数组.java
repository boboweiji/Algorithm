package offer;

public class 构建乘积数组 {
    public static int[] constructArr(int[] a) {
        int leftSum = 1;
        int rightSum = 1;
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int[] result = new int[a.length];
        for(int i=0;i<a.length;i++){
            left[i] = leftSum;
            leftSum *= a[i];
        }
        for(int i=a.length-1;i>=0;i--){
            right[i] = rightSum;
            rightSum *= a[i];
        }
        for(int i=0;i<a.length;i++){
            result[i] = left[i]*right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        constructArr(arr);
    }
}
