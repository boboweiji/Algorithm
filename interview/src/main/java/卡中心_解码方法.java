import java.util.Scanner;

public class 卡中心_解码方法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(fun(s));

    }

    private static int fun(String s){
        if(s.startsWith("0")) return 0;
        else if(s.length()==0 || s.length()==1) return 1;
        else {
            int cur = Integer.parseInt(s.substring(0,2));
            if(cur <= 26){
                return fun(s.substring(1))+fun(s.substring(2));
            } else {
                return fun(s.substring(1));
            }
        }
    }
}
