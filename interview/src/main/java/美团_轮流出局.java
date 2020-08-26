import java.util.Scanner;

public class 美团_轮流出局 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int cur = in.nextInt();
            int real = cur%(n-i);
            int index = 0;
            for(int j=0;j<n;j++){
                if(res[j]==0){
                    if(index==real)
                        res[j] = n-i;
                    index++;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(res[i]);
        }
    }
}
