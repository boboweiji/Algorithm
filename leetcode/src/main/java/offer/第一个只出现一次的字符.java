package offer;

import java.util.HashMap;
import java.util.Map;

public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i],!map.containsKey(arr[i]));
        }
        for(int i=0; i<arr.length; i++){
            if(map.get(arr[i])){
                return arr[i];
            }
        }
        return ' ';
    }
}
