package offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 翻转单词顺序 {
    public String reverseWords(String s) {
        if(s.trim().length()==0)
            return "";
        String[] ss = s.trim().split(" ");
        List<String> list = Arrays.asList(ss);
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for(String item : list){
            if(item.trim().length()!=0)
                sb.append(item).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
