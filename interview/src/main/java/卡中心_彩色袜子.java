import java.util.Scanner;

public class 卡中心_彩色袜子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;i++){
            int n = scanner.nextInt();
            int result = 0;
            boolean flag = false;
            for(int j=0;j<n;j++) {
                int cur = scanner.nextInt();
                if (cur > 0) {
                    result++;
                    if (cur >= 2)
                        flag = true;
                }
            }
            if(flag)
                System.out.println(result+1);
            else
                System.out.println(-1);
        }
    }
}
