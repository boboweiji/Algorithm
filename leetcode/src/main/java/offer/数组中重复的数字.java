package offer;

import java.util.HashSet;
import java.util.Set;

public class 数组中重复的数字 {
    Set<Integer> set = new HashSet<>();
    public int findRepeatNumber(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
}
