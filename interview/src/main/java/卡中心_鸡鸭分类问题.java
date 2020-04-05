import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 卡中心_鸡鸭分类问题 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        List<Integer> listD = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='D'){
                listD.add(i);
            }
        }
        int size = listD.size();
        if (size == 0 || size == n){
            System.out.println(0);
        } else {
            int z = 0;
            int f = 0;
            for(int i=0;i<size;i++){
                z += listD.get(i)-i;
                f += (n-1-listD.get(i))-(size-1-i);
            }
            System.out.print(Math.min(z,f));
        }
    }
}
