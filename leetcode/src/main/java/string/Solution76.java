package string;

import java.util.*;

public class Solution76 {
    public static String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        int n = t.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(map.containsKey(c)){
                int temp = map.get(c);
                map.put(c,++temp);
            } else {
                map.put(c,1);
            }
        }
        int count = 0;
        int resstart = 0;
        int resend = 0;
        int min = Integer.MAX_VALUE;
        while (end < s.length()){
            char c = s.charAt(end);
            if(start==end && !map.containsKey(c)){
                start++;
                end++;
                continue;
            } else if(!map.containsKey(c)){
                end++;
                continue;
            }
            if(map.containsKey(c)){
                if(map.get(c)>0){
                    int temp = map.get(c);
                    map.put(c,--temp);
                    end++;
                    count++;
                    if(count == n){
                        if(end-start < min){
                            min = end-start;
                            resend = end;
                            resstart = start;
                        }
                    }
                    continue;
                } else if(c!=s.charAt(start)){
                    int temp = map.get(c);
                    map.put(c,--temp);
                    end++;
                    continue;
                } else if(c == s.charAt(start)){
                    start++;
                    while(start!=end && (!map.containsKey(s.charAt(start)) || map.get(s.charAt(start))<0)){
                        if(map.containsKey(s.charAt(start))){
                            int temp = map.get(s.charAt(start));
                            map.put(s.charAt(start),++temp);
                        }
                        start++;
                    }
                    end++;
                    if(count == n && end-start < min){
                        min = end-start;
                        resend = end;
                        resstart = start;
                    }
                }
            }
        }
        if(resend == 0 && resstart==0){
            return "";
        }else{
            return s.substring(resstart,resend);
        }
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
