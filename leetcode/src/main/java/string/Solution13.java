package string;
import java.util.*;

// 罗马数字转整数
public class Solution13 {
    public static int romanToInt(String s) {
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for(int i = 0; i< s.length(); i+=1){
            if(i==s.length()-1){
                res += map.get(s.charAt(i));
            } else {
                if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                    res -= map.get(s.charAt(i));
                }else {
                    res += map.get(s.charAt(i));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}