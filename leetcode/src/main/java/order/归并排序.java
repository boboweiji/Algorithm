package order;

public class 归并排序 {
    public static int[] sortArray(int[] nums) {
        if(nums==null || nums.length<2){
            return nums;
        }
        mergeSort(nums,0, nums.length-1);
        return nums;
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int index = 0;
        int left = start;
        int right = mid+1;
        int[] temp = new int[end-start+1];
        while (left<=mid && right<=end){
            if(nums[left]<=nums[right]){
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }
        while (left<=mid){
            temp[index++] = nums[left++];
        }
        while (right<=end){
            temp[index++] = nums[right++];
        }
        for(int i=start;i<=end;i++){
            nums[i] = temp[i-start];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        sortArray(nums);
        System.out.println(nums);
    }
}
