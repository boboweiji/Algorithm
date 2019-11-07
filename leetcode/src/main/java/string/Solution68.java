package string;

import java.util.*;

public class Solution68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        int index = 0;
        int start = 0;
        int end = 0;
        int len = words.length;
        int wordLen = 0;
        int totalLen = 0;
        List<String> res = new ArrayList<>();
        while (index<len){
            while (totalLen<=maxWidth+1 && index <= len){
                if(index < len){
                    wordLen += words[index].length();
                    totalLen += words[index].length() + 1;
                }
                index++;
            }
            index--;
            end = index;
            StringBuilder sb = new StringBuilder();
            if(end != len) {
                wordLen -= words[end].length();
                int blank = maxWidth-wordLen;
                int interval = end - start -1;
                if(interval==0){
                    sb.append(words[end-1]);
                    int cur = sb.length();
                    for(int i=cur;i<maxWidth;i++){
                        sb.append(' ');
                    }
                } else {
                    for(int i = end-1;i>=start;i--){
                        sb.insert(0,words[i]);
                        if(interval != 0){
                            for(int j=0;j<blank/interval;j++){
                                sb.insert(0,' ');
                            }
                            blank -= blank/interval;
                            interval--;
                        }
                    }
                }
                res.add(sb.toString());
                start = end;
                wordLen = 0;
                totalLen = 0;
            } else {
                for(int i = start;i<end;i++){
                    sb.append(words[i]);
                    if(sb.length()==maxWidth){
                        break;
                    }
                    sb.append(' ');
                }
                int cur = sb.length();
                for(int i=cur;i<maxWidth;i++){
                    sb.append(' ');
                }
                res.add(sb.toString());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        int maxWidth = 16;
        System.out.println(fullJustify(words,16).toString());
    }
}
