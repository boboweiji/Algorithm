package string;

import java.util.*;

//括号生成
public class Solution22 {
    public static List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        ls.add("(");
        li.add(1);
        String cur = ls.get(0);
        while (cur.length()<2*n){
            int curInt = li.get(0);
            ls.remove(0);
            li.remove(0);
            if(cur.length()-curInt == curInt){
                ls.add(cur+"(");
                li.add(++curInt);
            } else if (n == curInt) {
                ls.add(cur+")");
                li.add(curInt);
            } else {
                ls.add(cur+")");
                li.add(curInt);
                ls.add(cur+"(");
                li.add(++curInt);
            }
            cur = ls.get(0);
        }
        return ls;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n).toString());
    }
}
