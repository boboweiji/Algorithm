import java.util.Scanner;

public class 卡中心_X游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for(int i=1;i<=n;i++){
            boolean flag = false;
            String s = String.valueOf(i);
            for(int j=0;j<s.length();j++){
                char cur = s.charAt(j);
                if(cur=='3' || cur=='4'||cur=='7'){
                    flag = false;
                    break;
                } else if(cur == '2' || cur == '5'
                        || cur == '6'|| cur == '9'){
                    flag = true;
                }
            }
            if(flag)
                count++;
        }
        System.out.println(count);
    }
}
