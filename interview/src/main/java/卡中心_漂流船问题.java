import java.util.Arrays;
import java.util.Scanner;

public class 卡中心_漂流船问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int limit = scanner.nextInt();
        Arrays.sort(a);
        int cnt = 0;
        int min = 0;
        int max = a.length-1;
        while(min<=max){
            if(a[min]+a[max]<=limit){
                cnt ++;
                min++;
                max--;
            } else {
                cnt++;
                max--;
            }
        }
        System.out.println(cnt);
    }
}
