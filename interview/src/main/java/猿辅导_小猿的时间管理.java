
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*class Course implements Comparable<Course> {
    public int start;
    public int end;

    public Course(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Course o) {
        if(this.start>=o.start&&this.end>=o.end){
            return 1;
        } else if(this.start<=o.start&&this.end<=o.end){
            return -1;
        } else {
            return 0;
        }
    }
}*/
public class 猿辅导_小猿的时间管理 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Map<Integer,Integer> maps = new HashMap<>();
        Map<Integer,Integer> mape = new HashMap<>();
        int minstart = Integer.MAX_VALUE;
        int maxstart = 0;
        for(int i=0;i<N;i++){
            int s = in.nextInt();
            int e = in.nextInt();
            if(s<minstart) minstart = s;
            if(s>maxstart) maxstart = s;
            if(maps.containsKey(s)){
                int cur = maps.get(s);
                maps.put(s,++cur);
            }
            if(mape.containsKey(e)){
                int cur = mape.get(e);
                mape.put(e,++cur);
            }
            maps.putIfAbsent(s,1);
            mape.putIfAbsent(e,1);
        }
        int result = 0;
        int cur = 0;
        for(int index = minstart;index<=maxstart;index++){
            if(mape.containsKey(index)){
                cur -= mape.get(index);
            }
            if(maps.containsKey(index)){
                cur += maps.get(index);
            }
            if(cur>result){
                result = cur;
            }
        }
        System.out.println(result);
    }
}