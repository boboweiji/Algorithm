package offer;

public class 扑克牌顺子 {

    public boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length==0){
            return false;
        }
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        int zeroCount = 0;
        for(int i=0; i<numbers.length; i++){
            int cur = numbers[i];
            if(cur == 0){
                zeroCount++;
                continue;
            }else if(cur<low || cur>high){
                return false;
            }else if(cur-4==low || cur+4 == low){
                return false;
            }else{
                int curlow = cur-4;
                int curhigh = cur+4;
                if(curlow>low){
                    low = curlow;
                }
                if(curhigh<high){
                    high = curhigh;
                }
            }
        }
        if(high-low-zeroCount<=5){
            return true;
        }
        return false;
    }

}
