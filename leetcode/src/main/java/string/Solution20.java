package string;

import java.util.Stack;

// 有效的括号
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char cur = stack.peek();
                if(c == ')') {
                    if(cur == '(') {
                        stack.pop();
                    }else {
                        return false;
                    }
                } else if(c == ']') {
                    if(cur == '[') {
                        stack.pop();
                    }else {
                        return false;
                    }
                } else {
                    if(cur == '{') {
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
