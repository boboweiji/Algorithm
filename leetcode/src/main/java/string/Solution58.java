package string;

public class Solution58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();
        int res = 0;
        if(n==0){
            return 0;
        }
        else{
            for(int i = n-1;i>=0;i--){
                if(s.charAt(i)!=' '){
                    res++;
                }else{
                    break;
                }
            }
        }
        return res;
    }
}
