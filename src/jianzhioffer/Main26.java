package jianzhioffer;

import java.util.Stack;

/**
 * 栈的压入、弹出系列
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Main26 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        System.out.println(IsPopOrder(a, b));
    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null && popA == null)
            return true;

        Stack<Integer> stack = new Stack<>();
        int indexA = 0;
        int indexB = 0;
        while(indexB<popA.length){
            if(stack.isEmpty()){
                stack.push(pushA[indexA++]);
            }
            if(stack.peek() != popA[indexB]){
                if(indexA < pushA.length)
                    stack.push(pushA[indexA++]);
                else
                    break;
            } else {
                stack.pop();
                indexB++;
            }
        }

        if(stack.isEmpty())
            return true;
        return false;
    }

}
