package jianzhioffer;

import java.util.Scanner;

/**
 * 剪绳子
 *
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 输出描述:
 * 输出答案。
 * 示例1
 * 输入
 * 8
 * 输出
 * 18
 */
public class Main01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        System.out.println(cutRope(num));
    }

    public static int cutRope(int target) {

        return cutRope(target, 0);
    }

    public static int cutRope(int target, int max) {
        int maxValue = max;
        for(int i = 1; i < target; ++i){
            maxValue = Math.max(maxValue, i*cutRope(target -i, target -i));
        }
        return maxValue;
    }

}
/**
 * 解题思路：
 * 利用递归
 * 特殊情况：注意取值 n >= 2 、m > 1
 */