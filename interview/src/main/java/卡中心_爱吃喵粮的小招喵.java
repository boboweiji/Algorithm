import java.util.Scanner;

public class 卡中心_爱吃喵粮的小招喵 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] in = scanner.nextLine().split(" ");
        int h = scanner.nextInt();
        int[] ints = new int[in.length];
        int sum = 0;
        for(int i=0;i<ints.length;i++){
            int cur = Integer.parseInt(in[i]);
            sum += cur;
            ints[i] = cur;
        }
        int i;
        int start = sum%h == 0? sum/h:sum/h+1;
        for(i=start;;i++){
            int cnt = 0;
            for(int j=0; j<in.length;j++){
                cnt+= ints[j]%i == 0? ints[j]/i:ints[j]/i+1;
            }
            if(cnt<=h)
                break;
        }
        System.out.println(i);
    }
}
