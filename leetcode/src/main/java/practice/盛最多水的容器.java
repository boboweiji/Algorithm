package practice;

public class 盛最多水的容器 {
    public static int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0;
        int cur;
        while(left<right){
            int h = Math.min(height[left],height[right]);
            cur = (right-left)*h;
            if(cur>max) max = cur;
            if(height[left]<=height[right]) left++;
            else right--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(maxArea(height));
    }
}
