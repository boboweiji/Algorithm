package string;

public class Solution125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if((c>='0'&&c<='9')||(c>='a'&&c<='z')){
                sb1.append(c);
            }
        }
        return sb1.toString().equals(sb1.reverse().toString());
    }
}
