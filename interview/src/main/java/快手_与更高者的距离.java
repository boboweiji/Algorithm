public class 快手_与更高者的距离 {
    /**
     * 获取队中从前到后每个人与前方身高高于自己的人的最短距离
     * @param height int整型一维数组 队中从前到后每个人与前方身高高于自己的人的最短距离
     * @return int整型一维数组
     */
    public int[] DistanceToHigher (int[] height) {
        int size = height.length;
        int[] result = new int[size];
        int max = 0;
        for(int i=1;i<size;i++){
            for(int j=i-1;j>=0;j--){
                if(height[j]>height[i]){
                    result[i] = i-j;
                    break;
                }
            }
        }
        return result;
    }
}
