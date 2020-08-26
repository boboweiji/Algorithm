package offer;

public class 扑克牌中的顺子 {
    public static boolean isStraight(int[] nums) {
        int[] arr = new int[14];
        int min = 14;
        int max = 0;
        for(int i=0;i<5;i++){
            if(nums[i]!=0){
                if(arr[nums[i]-1]>0)
                    return false;
                else {
                    arr[nums[i]-1] = 1;
                    if(nums[i]>max)
                        max = nums[i];
                    if(nums[i]<min)
                        min = nums[i];
                }
            }
        }
        return max-min<5;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(isStraight(nums));
    }
}
