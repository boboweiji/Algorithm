package offer;

public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt((i+n)%s.length()));
        }
        return sb.toString();
    }

    //使用substring
    public String reverseLeftWords1(String s, int n) {
        return s.substring(n)+s.subSequence(0,n);
    }
}
