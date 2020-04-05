import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

public class 卡中心_供水点 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];
        for(int i=0; i<n; i++){
            a[i] = scanner.nextInt();
        }
        for(int i=0; i<m; i++){
            b[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int result = 0;
        int indexB = 0;
        int i;
        for(i=0; i<a.length; i++){
            while(indexB < b.length && b[indexB]<a[i]){
                indexB++;
            }
            if(indexB==0){
                result = b[indexB]-a[i];
            }else if(indexB == b.length){
                result = max(result,a[a.length-1]-b[indexB-1]);
                break;
            }else{
                result = max(max(b[indexB]-a[i],a[i]-b[indexB-1]),result);
            }
        }
        System.out.println(result);
    }
}
