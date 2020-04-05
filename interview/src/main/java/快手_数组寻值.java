import java.util.ArrayList;
import java.util.Scanner;

public class 快手_数组寻值 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if(input.equals("")){
            System.out.println("-1");
        } else {
            String[] array = input.split(" ");
            StringBuilder sb = new StringBuilder();
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
            for(int i=0; i<array.length;i++){
                int cur = Integer.parseInt(array[i]);
                if(cur>=second&&cur<first){
                    sb.append(i).append(" ");
                }
                if(cur>first){
                    second = first;
                    first = cur;
                } else if(cur>second){
                    second = cur;
                }
            }
            if(sb.length() == 0){
                System.out.println("-1");
            }else{
                System.out.println(sb.deleteCharAt(sb.length()-1).toString());
            }
        }
    }
}
