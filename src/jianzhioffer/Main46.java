package jianzhioffer;

import java.util.Stack;

/**
 * leetcodes
 * 包含min函数的栈
 * @author lzz
 * @date 2019/12/16
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Main46 {

    Stack<Integer> stack = new Stack();
    Stack<Integer> stack2 = new Stack();

    public void push(int node) {
        stack.push(node);
        if(stack2.empty()){
            stack2.push(node);
        }else if(stack2.peek() >= node){
            stack2.push(node);
        }
    }

    public void pop() {
        int num = stack.pop();
        if(!stack2.empty() && stack2.peek() == num){
            stack2.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack2.peek();
    }

}
