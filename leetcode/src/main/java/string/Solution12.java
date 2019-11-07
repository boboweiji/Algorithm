package string;

// 整数转罗马数字
public class Solution12 {
    public static String intToRoman(int num) {
        String res = "";
        String[] numbers = {"I","V","X","L","C","D","M"};
        int count = 1;
        while (num!=0){
            int shu = num%10;
            if(shu == 4){
                res = numbers[count-1] + numbers[count] + res;
            } else if(shu == 9) {
                res = numbers[count-1] + numbers[count+1] + res;
            } else if(shu == 5){
                res = numbers[count] + res;
            } else {
                int yu = shu%5;
                String temp = "";
                if(yu<4){
                    for(int i=0;i<yu;i++){
                        temp = numbers[count-1] + temp;
                    }
                }else {
                    temp = numbers[count-1] + numbers[count];
                }
                if(shu>5){
                    temp = numbers[count] + temp;
                }
                res = temp + res;
            }
            num /= 10;
            count += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }
}
