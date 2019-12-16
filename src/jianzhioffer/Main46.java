package jianzhioffer;

import java.util.Stack;

/**
 * leetcodes
 * ����min������ջ
 * @author lzz
 * @date 2019/12/16
 *
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
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
