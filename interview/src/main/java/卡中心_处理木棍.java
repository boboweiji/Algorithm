import java.util.Arrays;
import java.util.Scanner;

class Stick implements Comparable<Stick> {
    private int length;
    private int weight;

    public int getLength() {
        return length;
    }

    public int getWeight() {
        return weight;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public int compareTo(Stick o) {
        if(this.length>=o.getLength()&&this.weight>=o.getWeight()){
            return 1;
        } else if(this.length<=o.getLength()&&this.weight<=o.getWeight()){
            return -1;
        } else {
            return 0;
        }
    }
}

public class 卡中心_处理木棍 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;i++){
            int n = scanner.nextInt();
            int result = 1;
            Stick[] sticks = new Stick[n];
            for(int j=0;j<n;j++) {
                sticks[j] = new Stick();
                sticks[j].setLength(scanner.nextInt());
            }
            for(int j=0;j<n;j++) {
                sticks[j].setWeight(scanner.nextInt());
            }
            Arrays.sort(sticks);
            for(int j=1;j<n;j++){
                if(sticks[j].compareTo(sticks[j-1]) > 0){
                    continue;
                } else {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
