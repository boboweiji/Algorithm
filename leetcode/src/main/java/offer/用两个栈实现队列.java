package offer;

import java.util.Stack;

class CQueue {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    int size;

    public CQueue() {
        size = 0;
    }

    public void appendTail(int value) {
        if(out.size() == 0){
            in.push(value);
            size++;
        } else {
            while (out.size() != 0){
                in.push(out.pop());
            }
            in.push(value);
            size++;
        }
    }

    public int deleteHead() {
        if(size == 0){
            return -1;
        } else {
            if(in.size() == 0){
                size--;
                return out.pop();
            } else {
                while (in.size() != 0){
                    out.push(in.pop());
                }
                size--;
                return out.pop();
            }
        }
    }

    // 更好的方法
    public void appendTail1(int value) {
        in.push(value);
    }

    // 更好的方法
    public int deleteHead1() {
        if (in.isEmpty() && out.isEmpty())
            return -1;
        if (out.isEmpty()){
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}

public class 用两个栈实现队列 {

}
