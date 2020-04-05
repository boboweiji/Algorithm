package offer;

import java.util.LinkedList;
import java.util.List;

public class 孩子们的游戏_圆圈中最后剩下的数 {
    public int LastRemaining_Solution(int n, int m) {
        if(n==0){
           return -1;
        } else {
            List<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < n; i ++) {
                list.add(i);
            }

            int index = 0;
            while (list.size() > 1) {
                index = (index + m - 1) % list.size();
                list.remove(index);
            }

            return list.get(0);
        }
    }
}
