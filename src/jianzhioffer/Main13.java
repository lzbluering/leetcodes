package jianzhioffer;

/**
 * 不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Main13 {

    public int Add(int num1,int num2) {
        if(num2 == 0){
            return num1;
        }
        int a = num1 ^ num2;
        int b = num1 & num2;
        b = b << 1;

        return Add(a, b);
    }
}
