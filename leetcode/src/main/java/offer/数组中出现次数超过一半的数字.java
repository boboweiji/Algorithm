package offer;

import java.util.Arrays;

public class 数组中出现次数超过一半的数字 {
    // 数组排序
    public int majorityElement(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        return nums[size/2];
    }

    // 摩尔投票
    public int majorityElement1(int[] nums) {
        int vote = 0;
        int zhong = 0;
        for(int i=0; i<nums.length; i++){
            if(vote==0){
                zhong = nums[i];
                vote++;
            } else {
                if(zhong == nums[i]) vote++;
                else vote--;
            }
        }
        return zhong;
    }
}
