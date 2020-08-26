import java.util.Arrays;
import java.util.Scanner;

public class 美团_小团的AB队 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] arr = new int[x+y];
        int[] seq = new int[x+y];
        int[] location = new int[20000];
        char[] team = new char[20000];
        for(int i=0;i<x+y;i++){
            arr[i] = scanner.nextInt();
            seq[i] = arr[i];
        }
        if(x==y){
            for(int i=0;i<x;i++) System.out.print("A");
            for(int i=0;i<y;i++) System.out.print("B");
        } else {
            Arrays.sort(seq);
            for(int i=0;i<x+y;i++){
                location[seq[i]] = i;
            }
            if(x/2==0){
                for(int i=0; i<x/2; i++){
                    team[arr[i]] = 'A';
                    if(location[arr[i]]>(x+y)/2){

                    }
                }
            }
        }
    }
}
