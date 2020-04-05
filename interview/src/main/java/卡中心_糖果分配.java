import java.util.Arrays;
import java.util.Scanner;

public class 卡中心_糖果分配 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] b = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int count = 0;
        for(int i=0; i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(b[j] == 0) continue;
                else if(b[j]>=a[i]){
                    b[j] = 0;
                    count++;
                    break;
                }
            }
            if(count == b.length)
                break;
        }
        System.out.println(count);
    }
}
