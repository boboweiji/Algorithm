import java.util.Scanner;

public class 卡中心_跳格子游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(jump(n));
    }

    private static int jump(int n){
        if(n==1){
            return 1;
        } else if(n==2){
            return 2;
        } else {
            return jump(n-1)+jump(n-2);
        }
    }
}
