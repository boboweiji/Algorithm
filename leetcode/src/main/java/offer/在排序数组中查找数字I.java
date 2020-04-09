package offer;

public class 在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        int i = 0, left = 0, right = 0;
        int j = nums.length-1;
        while (i<=j){
            int mid = (i+j)/2;
            if(nums[mid]<=target){
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        right = i;
        i = 0;
        j = nums.length-1;
        while (i<=j){
            int mid = (i+j)/2;
            if(nums[mid]>=target){
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        left = j;
        return right-left+1;
    }
}
