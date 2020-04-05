import java.util.Scanner;

public class 卡中心_员工考勤记录 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n==1) System.out.println(n);
        else{
            System.out.println(1+n+(n*(n-1))/2);
        }
    }
}
