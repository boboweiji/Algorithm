package string;

import java.util.*;

//电话号码的字母组合
public class Solution17 {
    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    static List<String> output = new ArrayList<String>();

    public static void backtrack(String combination, String next_digits) {
        if(next_digits.length() == 0){
            output.add(combination);
        } else {
            String num = next_digits.substring(0,1);
            for(int i=0; i<phone.get(num).length(); i++){
                String new_combination = combination + phone.get(num).substring(i,i+1);
                String new_next_digits = next_digits.substring(1);
                backtrack(new_combination,new_next_digits);
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    public static void main(String[] args) {
        String s = "223";
        System.out.println(letterCombinations(s).toString());

    }
}
