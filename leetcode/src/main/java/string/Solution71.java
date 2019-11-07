package string;

import java.util.*;

public class Solution71 {
    public static String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<path.length();i++){
            char c = path.charAt(i);
            if(c=='/'){
                if(stack.size() !=0 && (i==path.length()-1 || stack.peek()=='/')){
                    continue;
                }else {
                    stack.push(c);
                }
            } else if(c=='.'){
                int countd = 0;
                int total = 0;
                for(int j=i;j<path.length();j++){
                    if(path.charAt(j)=='.'){
                        countd++;
                        total++;
                    }else if(path.charAt(j)=='/'){
                        break;
                    } else {
                        total++;
                    }
                }
                if(countd<=2 && countd == total){
                    if(stack.size()>1){
                        stack.pop();
                    }
                    if(countd == 2){
                        while (stack.peek()!='/'){
                            stack.pop();
                        }
                        if(stack.size()==1){
                            i++;
                            continue;
                        }else {
                            stack.pop();
                            i++;
                            continue;
                        }
                    }
                } else {
                    for(int j=i;j<i+total;j++){
                        stack.push(path.charAt(j));
                    }
                    i += total-1;
                    continue;
                }
            } else{
                stack.push(c);
            }
        }
        if(stack.size() > 1 && stack.peek()=='/'){
            stack.pop();
        }
        StringBuilder res = new StringBuilder();
        while (stack.size() !=0){
            res.insert(0,stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String path = "/abc/...";
        System.out.println(simplifyPath(path));;
    }
}
