package string;

// 字符串转换整数
public class Solution8 {
    public static int myAtoi(String str) {
        char first = ' ';
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        str = str.trim();
        if(str.length()==0)
            return 0;
        first = str.charAt(i);
        if(first == '-'){
            i++;
            stringBuilder.append('-');
        }
        if(first == '+'){
            i++;
        }
        while(i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            stringBuilder.append(str.charAt(i));
            i++;
        }
        if(stringBuilder.length() == 0) {
            return 0;
        }
        int res = 0;
        try{
            res = Integer.parseInt(stringBuilder.toString());
        }catch(Exception e){
            Integer max = Integer.MAX_VALUE;
            Integer min = Integer.MIN_VALUE;
            if(first == '-'){
                if(stringBuilder.toString().length()>min.toString().length()){
                    return min;
                }else if(stringBuilder.toString().compareTo(min.toString())>0){
                    return min;
                }
            }else{
                if(stringBuilder.toString().length()>max.toString().length()){
                    return max;
                }else if(stringBuilder.toString().compareTo(max.toString())>0){
                    return max;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "20000000000000000000";
        System.out.println(myAtoi(s));
    }
}
