package string;

public class Solution28 {

    // KMP
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }
        int n = needle.length();
        int m = haystack.length();
        int[] next = new int[n];
        next[0] = 0;
        int i = 0;
        for(int j=1; j<n; j++){
            if(needle.charAt(i) == needle.charAt(j)){
                i++;
                next[j] = i;
            }else {
                if(i==0){
                    next[j] = 0;
                } else {
                    while (i!=0 && needle.charAt(i) != needle.charAt(j))
                        i = next[i-1];
                    if(needle.charAt(i) == needle.charAt(j)){
                        i++;
                        next[j] = i;
                    }
                }
            }
        }
        int k = 0,j = 0;
        while (k<m && j<n){
            if(haystack.charAt(k) == needle.charAt(j)){
                k++;
                j++;
            } else {
                if(j==0){
                    k++;
                    continue;
                }
                j = next[j-1];
            }
        }
        if(j == n){
            return (k-n);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        System.out.println(strStr(haystack,needle));
        //System.out.println(haystack.indexOf(needle));
    }
}
