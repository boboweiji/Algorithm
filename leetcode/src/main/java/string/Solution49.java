package string;

import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List> res = new HashMap<>();
        if(strs.length == 0){
            return new ArrayList<>();
        }
        int[] a = new int[26];
        for(String s : strs){
            Arrays.fill(a,0);
            for(int i=0; i<s.length(); i++){
                a[s.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append(a[i]);
            }
            if(res.containsKey(sb.toString())){
                res.get(sb.toString()).add(s);
            }else{
                res.put(sb.toString(),new ArrayList());
                res.get(sb.toString()).add(s);
            }
        }
        return new ArrayList(res.values());
    }
}
