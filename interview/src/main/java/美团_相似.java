import java.util.Scanner;

public class 美团_相似 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        int[] res = new int[n];
        for(int i=0; i<n-1; i++){
            if(res[i] == 0)
                res[i] = -1;
            for(int j=i+1; j<n; j++){
                if(res[j]==1)
                    continue;
                if((a[i]&a[j])==0){
                    res[i] = 1;
                    res[j] = 1;
                    break;
                }
            }
        }
        if(res[n-1] == 0)
            res[n-1] = -1;
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
}
