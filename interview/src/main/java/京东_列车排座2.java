import java.util.Arrays;
import java.util.Scanner;

class Target implements Comparable<Target>{
    int x;
    int y;

    Target(int a,int b){
        x = a;
        y = b;
    }

    @Override
    public int compareTo(Target o) {
        if(this.x-o.x !=0)
            return this.x-o.x;
        else
            return this.y-o.y;
    }
}

public class 京东_列车排座2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Target[] targets = new Target[n];
        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            targets[i] = new Target(a,b);
        }
        Arrays.sort(targets);
        int index = 0;
        int result = 0;
        while (index<n){
            if(visited[index]==1){
                index++;
                continue;
            }
            visited[index] = 1;
            result++;
            int end = targets[index].y;
            for(int j=index+1;j<n;j++){
                if(visited[j]!=1 && targets[j].x>=end){
                    visited[j] = 1;
                    end = targets[j].y;
                }
            }
            index++;
        }
        System.out.println(result+1);
    }

}
