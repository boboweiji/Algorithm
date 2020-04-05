package offer;

public class 旋转数组的最小数字 {
    // 常规方法
    public int minArray(int[] numbers) {
        int min = numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<numbers[i-1]){
                min = numbers[i];
                break;
            }
        }
        return min;
    }

    // 二分法
    public int minArray1(int[] numbers) {
        int start = 0;
        int end = numbers.length-1;
        while (start < end){
            int mid = (start+end)/2;
            if(numbers[mid] < numbers[end]){
                end = mid;
                continue;
            } else if(numbers[mid] > numbers[end]) {
                start = mid + 1;
            } else {
                end--;
            }
        }
        return numbers[start];
    }
}
