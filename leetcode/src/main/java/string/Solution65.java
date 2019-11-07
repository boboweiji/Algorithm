package string;

public class Solution65 {
    public static boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0){
            return false;
        }
        int i = 0;
        boolean flag = false;
        boolean flage = false;
        boolean ans = false;
        while(i<s.length()){
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(i!= s.length()-1 && (i==0 || s.charAt(i-1)=='e')){
                    i++;
                    continue;
                } else {
                    return false;
                }
            } else if (s.charAt(i) == 'e') {
                if(i==0 || i==s.length()-1 || flage){
                    return false;
                } else if(s.charAt(i-1)<'0' || s.charAt(i-1)>'9') {
                    if(s.charAt(i-1) == '.' && ans){
                        flage = true;
                        i++;
                        continue;
                    }
                    return false;
                } else {
                    flage = true;
                    i++;
                    continue;
                }
            } else if(s.charAt(i) == '.'){
                if(s.length()==1 || flage || flag){
                    return false;
                } else if (i!=s.length()-1 && (s.charAt(i+1)<'0' || s.charAt(i+1)>'9') && s.charAt(i+1) != 'e'){
                    return false;
                } else if(i!=0 && (s.charAt(i-1)<'0' || s.charAt(i-1)>'9') && s.charAt(i-1) != '+' && s.charAt(i-1) != '-'){
                    return false;
                }else {
                    flag = true;
                    i++;
                    continue;
                }
            } else if (s.charAt(i)>='0' && s.charAt(i)<='9') {
                ans = true;
                i++;
                continue;
            } else {
                return false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("46.e3"));
    }
}
