package string;

// 最长回文子串
public class Solution5 {
    public static String longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return "";
        int center = 0;
        int maxlen = 0;
        for(int i=0;i<s.length();i++){
            int len1 = getlen(s,i,i);
            int len2 = getlen(s,i,i+1);
            int curlen = Math.max(len1,len2);
            if(curlen>maxlen){
                maxlen = curlen;
                center = i;
            }
        }
        return s.substring(center-(maxlen-1)/2,center-(maxlen-1)/2+maxlen);
    }

    public static int getlen(String s, int left, int right){
        while (left>=0 && right<s.length() && (s.charAt(left) == s.charAt(right))){
            right++;
            left--;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
