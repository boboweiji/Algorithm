import java.util.Scanner;

public class 美团_小美的用户名 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<m;i++){
            String s = scanner.nextLine();
            boolean numFlag = false;
            boolean abcFlag = false;
            boolean wrongFlag = false;
            if(!((s.charAt(0)>='a'&&s.charAt(0)<='z')||(s.charAt(0)>='A'&&s.charAt(0)<='Z'))){
                wrongFlag = true;
            }
            if(!wrongFlag){
                for(int j=1;j<s.length();j++){
                    if(s.charAt(j)>='0'&&s.charAt(j)<='9'){
                        numFlag = true;
                    }
                    else if((s.charAt(j)>='a'&&s.charAt(j)<='z')||(s.charAt(j)>='A'&&s.charAt(j)<='Z')){
                        abcFlag = true;
                    } else {
                        wrongFlag = true;
                        break;
                    }
                }
            }
            if(!wrongFlag&&numFlag&&abcFlag){
                System.out.println("Accept");
            } else {
                System.out.println("Wrong");
            }
        }
    }
}
