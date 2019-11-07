package string;

public class Solution151 {
    public String reverseWords(String s) {
        s=s.trim();
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for(int i=words.length-1;i>=0;i--){
            if(!words[i].trim().isEmpty()){
                if(i>0){
                    sb.append(words[i]);
                    sb.append(" ");
                } else {
                    sb.append(words[i]);
                }
            }
        }
        return sb.toString();
    }
}
