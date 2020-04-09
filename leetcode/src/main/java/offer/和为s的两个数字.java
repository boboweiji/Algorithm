package offer;

public class 和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start<end){
            if(nums[start]+nums[end] == target)
                return new int[]{nums[start],nums[end]};
            else if(nums[start]+nums[end] > target){
                end--;
            } else {
                start++;
            }
        }
        return new int[0];
    }
}
