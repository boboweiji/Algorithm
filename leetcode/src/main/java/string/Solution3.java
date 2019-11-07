package string;

import java.util.*;

// 无重复最长子串
public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        while (end < s.length()){
            char c = s.charAt(end);
            if(!set.contains(c)){
                set.add(c);
                if(end-start+1>res){
                    res = end-start+1;
                }
                end++;
                continue;
            }else{
                while (s.charAt(start) != c){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
                end++;
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "tttt";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
