package offer;

import java.util.Stack;

class MinStack{
    private Stack<Integer> master;
    private Stack<Integer> slave;
    /** initialize your data structure here. */
    public MinStack() {
        master = new Stack<>();
        slave = new Stack<>();
    }

    public void push(int x) {
        master.push(x);
        if(slave.isEmpty()||x<=slave.peek()){
            slave.push(x);
        }
    }

    public void pop() {
        if(master.peek().equals(slave.peek()))
            slave.pop();
        master.pop();
    }

    public int top() {
        return master.peek();
    }

    public int min() {
        return slave.peek();
    }
}

public class 包含min函数的栈 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
