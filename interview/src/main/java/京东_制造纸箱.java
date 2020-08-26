import java.util.*;

class Aspect implements Comparable<Aspect>{
    int x;
    int y;

    Aspect(int a,int b){
        x = Math.min(a,b);
        y = Math.max(a,b);
    }

    @Override
    public int compareTo(Aspect o) {
        if(this.x-o.x !=0)
            return this.x-o.x;
        else
            return this.y-o.y;
    }
}

public class 京东_制造纸箱 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++){
            Set<Integer> set = new HashSet<>();
            Aspect[] aspects = new Aspect[6];
            for(int j=0;j<6;j++){
                int a = in.nextInt();
                int b = in.nextInt();
                set.add(a);
                set.add(b);
                aspects[j] = new Aspect(a,b);
            }
            Arrays.sort(aspects);
            if(set.size()>3)
                System.out.println("IMPOSSIBLE");
            else if(aspects[0].x==aspects[1].x && aspects[2].x==aspects[3].x && aspects[4].x==aspects[5].x &&
                    aspects[0].y==aspects[1].y && aspects[2].y==aspects[3].y && aspects[4].y==aspects[5].y &&
                    aspects[0].y==aspects[4].x && aspects[2].y==aspects[4].y){
                System.out.println("POSSIBLE");
            }else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<T; i++){
            for(int j=0;j<12;j++){
                Integer cur = in.nextInt();
                if(map.get(cur)!=null){
                    int temp = map.get(cur);
                    map.put(cur,++temp);
                } else
                    map.put(cur,1);
            }
            String result = "POSSIBLE";
            if(map.size()>3)
                result = "IMPOSSIBLE";
            else {
                for(Map.Entry<Integer,Integer> item : map.entrySet()){
                    if(item.getValue()%2==1){
                        result = "IMPOSSIBLE";
                    }
                }
            }
            System.out.println(result);
        }
    }*/
}
