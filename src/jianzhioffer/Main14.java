package jianzhioffer;

/**
 * 把字符串转换成整数
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 示例1
 * 输入
 * +2147483647
 * 输出
 * 2147483647
 *
 * 示例2
 * a312
 * 0
 */
public class Main14 {
    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483649"));
    }

    public static int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }

        int index = 0;
        boolean flag = true;
        long ans = 0;
        while(index < str.length()){
            char c = str.charAt(index);
            if(index == 0){
                if(c == '+'){
                    flag = true;
                }else if(c == '-'){
                    flag = false;
                }else if(c >= '0' && c <='9'){
                    ans += (c-'0')*Math.pow(10, str.length()-1-index);
                }else{
                    return 0;
                }
            }else{
                if(c >= '0' && c <='9'){
                    ans += (c-'0')*Math.pow(10, str.length()-1-index);
                }else{
                    return 0;
                }
            }
            index++;
        }

        ans = flag ? ans : -ans;
        return (ans<Integer.MIN_VALUE || ans>Integer.MAX_VALUE) ? 0 : (int)ans;
    }
}
/**
 * 解题思路：
 * 1、首先考虑到首位是正负号的情况
 * 2、考虑极端情况：不在 [Integer.MIN_VALUE, Integer.MAX_VALUE] 区间的情况
 */