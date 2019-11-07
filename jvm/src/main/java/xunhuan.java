import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class xunhuan {
    public static void main(String[] args) {
       /* Scanner in = new Scanner(System.in);
        String s = in.next();
        String[] arrayS = s.split(",");
        BigDecimal a = new BigDecimal(arrayS[0]);
        BigDecimal b = new BigDecimal(arrayS[1]);
        a = a.divide(b, 200, BigDecimal.ROUND_UP );
        String temp = "" + a;
        String t = "" + Double.valueOf(arrayS[0]) / Double.valueOf(arrayS[1]);
        if(t.length() < 18) {
            System.out.println(t);
            return;
         }
        String temp1 = temp.substring(2);
        ArrayList<Character> list = new ArrayList<Character>();
        for(int i = 0;i < temp1.length();i++) {
            if(!list.contains(temp1.charAt(i)))
                list.add(temp1.charAt(i));
            else {
                int start = list.indexOf(temp1.charAt(i));
                int k = i, j = start;
                for(;j < list.size() && k < 198;j++,k++) {
                    if(list.get(j) != temp1.charAt(k))
                        break;
                    }
                if(j == list.size()) {
                    if((j - start == 1 && temp1.charAt(i) == '0')) {
                        list.add(temp1.charAt(i));
                        continue;
                    }
                    System.out.print(temp.substring(0, 2));
                    for(int p = 0;p < list.size();p++) {
                        if(p == start)
                            System.out.print("[");
                        System.out.print(list.get(p));
                        }
                    System.out.print("]");
                    return;
                    } else
                    list.add(temp1.charAt(i));
                }
            }*/
        System.out.println(divide(1,98));
        }

    public static String divide(int dividend, int divisor) {
        // Write your code here
        if(dividend/divisor * divisor == dividend) {
            return "" + dividend/divisor;
        }
        String res = "";
        String t = "" + Double.valueOf(dividend) / Double.valueOf(divisor);
        if(t.length() < 18) {
            return t;
        }
        String decimals = t.substring(2);
        ArrayList<Character> list = new ArrayList<Character>();
        for(int i = 0;i < decimals.length();i++) {
            if(!list.contains(decimals.charAt(i)))
                list.add(decimals.charAt(i));
            else {
                int start = list.indexOf(decimals.charAt(i));
                int k = i, j = start;
                for(;j < list.size();j++,k++) {
                    if(list.get(j) != decimals.charAt(k))
                        break;
                }
                if(j == list.size()) {
                    if((j - start == 1 && decimals.charAt(i) == '0')) {
                        list.add(decimals.charAt(i));
                        continue;
                    }
                    res += t.substring(0, 2);
                    for(int index = 0;index < list.size();index++) {
                        if(index == start)
                            res += "(";
                        res += list.get(index);
                    }
                    res += ")";
                    return res;
                } else
                    list.add(decimals.charAt(i));
            }
        }
        return res;
    }
}
