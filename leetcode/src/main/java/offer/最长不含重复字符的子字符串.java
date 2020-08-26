package offer;

import java.util.HashMap;
import java.util.Map;

public class 最长不含重复字符的子字符串 {
    public static int lengthOfLongestSubstring(String s) {
        int res  = 0;
        int start = -1;
        Map<Character,Integer> map = new HashMap<>();
        for(int end=0;end<s.length();end++){
            if(map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)), start);
            }
                map.put(s.charAt(end),end);
                res = Math.max(res,end-start);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
