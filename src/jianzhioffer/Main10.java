package jianzhioffer;

/**
 * leetcodes
 * 左旋转字符串
 * @author lzz
 * @date 2019/11/28
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class Main10 {

    public static void main(String[] args) {
        System.out.println(LeftRotateString("", 2));
    }

    public static String LeftRotateString(String str,int n) {
        if(str==null || str.length()<=1){
            return str;
        }

        if(n>=str.length()){
            n %= str.length();
        }

        String s1 = str.substring(n);
        String s2 = "";
        if(n != 0){
            s2 = str.substring(0,n);
        }

        return s1+s2;
    }

}
