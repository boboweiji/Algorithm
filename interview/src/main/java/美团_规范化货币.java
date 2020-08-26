import java.util.Scanner;

public class 美团_规范化货币 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.nextLine();
            boolean flag = true;
            String[] ss = s.split("\\.");
            if(ss.length==2) {
                if(ss[1].length()>=2)
                    ss[1] = ss[1].substring(0, 2);
                else
                    ss[1] = ss[1] + "0";
            }
            if(ss[0].startsWith("-")){
                ss[0] = ss[0].substring(1);
                flag = false;
            }
            int index = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=ss[0].length()-1;i>=0;i--){
                sb.append(ss[0].charAt(i));
                index++;
                if(index%3 == 0 && i != 0){
                    sb.append(",");
                }
            }
            ss[0] = "$" + sb.reverse().toString();
            if(flag) {
                if(ss.length==2){
                    System.out.println(ss[0]+"."+ss[1]);
                } else {
                    System.out.println(ss[0]+".00");
                }
            } else {
                if(ss.length==2){
                    System.out.println("("+ss[0]+"."+ss[1]+")");
                } else {
                    System.out.println("("+ss[0]+".00"+")");
                }
            }
        }
    }
}
