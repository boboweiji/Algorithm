import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 快手_计算累计平方和 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> good = new HashSet<>();
        Set<Integer> bad = new HashSet<>();
        good.addAll(Arrays.asList(new Integer[]{1,10,100,1000}));
        bad.add(0);
        int m = scanner.nextInt();
        for(int i=0; i<m; i++){
            int n = scanner.nextInt();
            Set<Integer> cur = new HashSet<>();
            while (true){
                if(good.contains(n)){
                    good.addAll(cur);
                    System.out.println(true);
                    break;
                } else if(bad.contains(n) || cur.contains(n)){
                    bad.addAll(cur);
                    System.out.println(false);
                    break;
                }
                cur.add(n);
                n = nextN(n);
            }
        }
    }

    private static int nextN(int n) {
        int result = 0;
        while(n!=0){
            result += Math.pow(n%10,2);
            n /= 10;
        }
        return result;
    }

}
