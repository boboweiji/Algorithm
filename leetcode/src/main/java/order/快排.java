package order;

public class 快排 {

    public static int[] sortArray(int[] nums) {
        if(nums==null || nums.length<2){
            return nums;
        }
        quickSort(nums,0, nums.length-1);
        return nums;
    }

    public static void quickSort(int[] arr, int start, int end){
        if(start<end){
            int index = getMiddle(arr,start,end);
            quickSort(arr,start,index-1);
            quickSort(arr,index+1,end);
        }
    }

    public static int getMiddle(int[] arr, int start, int end){
        int temp = arr[start];
        while (start<end){
            while (start<end && arr[end]>=temp){
                end--;
            }
            if(arr[end]<temp)
                arr[start] = arr[end];
            while (start<end && arr[start]<=temp){
                start++;
            }
            if(arr[start]>temp)
                arr[end] = arr[start];
        }
        arr[start]=temp;
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        sortArray(nums);
        System.out.println(nums);
    }
}
