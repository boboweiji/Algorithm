import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String car = sc.nextLine();
        String person = sc.nextLine();

        Map<Character,Integer> carMap = new HashMap<>();
        for(int i=0; i<n; i++){
            char ch = car.charAt(i);
            if(carMap.containsKey(ch)){
                carMap.put(ch,1);
            }else{
                int time = carMap.get(ch);
                carMap.put(ch, ++time);
            }
        }
        int start = 0; int end = 0;
        int res = 0;
        while(start<m){
            end = start;
            int count = 0;
            while(end<m){

            }
        }

    }

    static void print(int[][] matrix) {
        int xStart = 0;
        int xEnd = matrix.length - 1;
        int yStart = 0;
        int yEnd = matrix[0].length - 1;

        // 打印行right
        while (xStart <= xEnd && yStart <= yEnd) {
            if (xStart == xEnd && yStart == yEnd) {
                System.out.print(matrix[xStart][yStart]);
            }
            for (int i = xStart; i < xEnd; i++) {
                int j = yStart;
                int value = matrix[i][j];
                System.out.print(value+" ");
            }

            for (int j = yStart; j < yEnd; j++) {
                int i = xEnd;
                int value = matrix[i][j];
                System.out.print(value+" ");
            }

            //往回退的时候需要加个处理，就是防止重复打印
            for (int i = xEnd; i > xStart; i--) {
                int j = yEnd;
                int value = matrix[i][j];
                System.out.print(value+" ");
                if(yStart==yEnd){
                    break;
                }
            }

            for (int j = yEnd; j > yStart; j--) {
                int i = xStart;
                int value = matrix[i][j];
                System.out.print(value+" ");
                if(xStart==xEnd){
                    break;
                }
            }
            xStart++;
            yStart++;
            xEnd--;
            yEnd--;
        }
    }
}
