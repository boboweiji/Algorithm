package offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 字符串的排列 {
    List<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        digui(0);
        return res.toArray(new String[0]);
    }

    private void digui(int x) {
        if(x==c.length-1) {
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i=x; i<c.length;i++){
            if(set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            swap(i,x);
            digui(x+1);
            swap(i,x);
        }
    }

    private void swap(int c1, int c2) {
        char temp = c[c1];
        c[c1] = c[c2];
        c[c2] = temp;
    }


}
