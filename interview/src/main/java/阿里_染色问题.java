import java.util.Scanner;

public class 阿里_染色问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0;i<T;i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int c = scanner.nextInt();
            int[] arr = new int[c];
            int sum = 0,max = 0;
            for(int j=0;j<c;j++){
                arr[j] = scanner.nextInt();
                sum+=arr[j];
                if(arr[j]>max){
                    max = arr[j];
                }
            }
            if(max>(sum+1)/2)
                System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
