import java.util.Arrays;
import java.util.Scanner;

public class 阿里_小强修水渠 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
            scanner.nextInt();
        }
        long result = 0;
        Arrays.sort(arr);
        int temp = arr[n/2];
        for(int i=0;i<n;i++){
            result += Math.abs(arr[i]-temp);
        }
        System.out.println(result);
    }
}
