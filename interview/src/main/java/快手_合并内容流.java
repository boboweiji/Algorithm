import java.util.Scanner;

public class 快手_合并内容流 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        String[] s1 = string1.split(" ");
        String[] s2 = string2.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s2.length;i++){
            for(int j=i*4; j<i*4+4 && j<s1.length;j++){
                sb.append(s1[j]).append(" ");
            }
            sb.append(s2[i]).append(" ");
        }
        if(s1.length>s2.length*4){
            for(int i = s2.length*4; i<s1.length; i++){
                sb.append(s1[i]).append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

}
