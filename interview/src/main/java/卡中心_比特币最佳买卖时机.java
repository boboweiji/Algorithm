import java.util.Scanner;

public class 卡中心_比特币最佳买卖时机 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        String[] s = in.split(" ");
        int max = 0;
        int curMin = Integer.parseInt(s[0]);
        for(int i = 1; i<s.length; i++){
            int cur = Integer.parseInt(s[i]);
            if(cur - curMin > max)
                max = cur - curMin;
            if(cur < curMin){
                curMin = cur;
            }
        }
        System.out.println(max);
    }
}
