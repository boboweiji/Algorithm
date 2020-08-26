package offer;

import java.util.LinkedList;

public class 滑动窗口的最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new int[0];
        int size = nums.length-k+1;
        LinkedList<Integer> list = new LinkedList<>();
        int[] result = new int[size];
        for(int i=0;i<k;i++){
            while (list.size()!=0 && list.peekLast()<nums[i])
                list.removeLast();
            list.addLast(nums[i]);
        }
        result[0] = list.getFirst();
        for(int i=1;i<nums.length-k+1;i++){
            if(nums[i-1] == list.getFirst()){
                list.removeFirst();
            }
            while (list.size()!=0 && list.peekLast()<nums[i+k-1])
                list.removeLast();
            list.addLast(nums[i+k-1]);
            result[i] = list.getFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-7,-8,7,5,7,1,6,0};
        System.out.println(maxSlidingWindow(nums,4));
    }
}
