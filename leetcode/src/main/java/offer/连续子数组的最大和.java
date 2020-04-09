package offer;

public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1; i<size; i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if(max<dp[i])
                max = dp[i];
        }
        return max;
    }
}
