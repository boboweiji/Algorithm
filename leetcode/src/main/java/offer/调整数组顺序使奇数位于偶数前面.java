package offer;

public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int ouIndex = 0;
        int index = 0;
        while (index<nums.length&&nums[index]%2==1){
            index++;
        }
        if(index<nums.length&&nums[index]%2==0){
            ouIndex = index;
        }
        while (index<nums.length){
            while (index<nums.length&&nums[index]%2==0){
                index++;
            }
            if(index<nums.length&&nums[index]%2==1){
                int temp = nums[index];
                nums[index] = nums[ouIndex];
                nums[ouIndex] = temp;
                ouIndex++;
            }
        }
        return nums;
    }

    // 首尾双指针比较好
    public int[] exchange1(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<right){
            while (left<nums.length &&(nums[left]&1)==1)
                left++;
            while (right>=0 && (nums[right]&1)==0)
                right--;
            if (left>=right)
                break;
            int mid=nums[left];
            nums[left]=nums[right];
            nums[right]=mid;
        }
        return nums;
    }
}
