package jianzhioffer;

import java.util.Stack;

/**
 * ջ��ѹ�롢����ϵ��
 *
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 * ��ע�⣺���������еĳ�������ȵģ�
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
