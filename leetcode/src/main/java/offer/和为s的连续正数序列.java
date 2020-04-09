package offer;

import java.util.ArrayList;
import java.util.List;

public class 和为s的连续正数序列 {
    public static int[][] findContinuousSequence(int target) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        int start = 1;
        int end = 2;
        while (start<end&&end<=target/2+1){
            int sum = (start+end)*(end-start+1)/2;
            if(sum==target){
                starts.add(start);
                ends.add(end);
                start++;
            } else if(sum<target){
                end++;
            } else {
                start++;
            }
        }
        int[][] result = new int[starts.size()][];
        for(int i=0;i<starts.size();i++){
            int[] res = new int[ends.get(i)-starts.get(i)+1];
            for(int j=starts.get(i);j<=ends.get(i);j++){
                res[j-starts.get(i)] = j;
            }
            result[i] = res;
        }
        return result;
    }

    public static void main(String[] args) {
        findContinuousSequence(9);
    }
}
