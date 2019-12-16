package jianzhioffer;

import java.util.BitSet;

/**
 * leetcodes
 * 数组中只出现一次的数字
 * @author lzz
 * @date 2019/12/16
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 *
 * //num1,num2分别为长度为1的数组。传出参数
 * //将num1[0],num2[0]设置为返回结果
 */
public class Main45 {

    public static void main(String[] args) {
        int num = -7^5;
        num &= -num;
        System.out.println(-num & 5);
    }

    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        //异或之后 diff 代表数组中没有相同数字的两个数字异或（相同数字异或等 0 ）
        for (int num : nums){
            diff ^= num;
        }

        //使 diff 值变为正值（绝对值）
        diff &= -diff;

        for (int num : nums) {
            //两个数中其中一个数和 diff的绝对值 与运算之后等于 0， 另一个不等于零，但是该数负值 与运算等于 0
            if ((num & diff) == 0){
                //排除其中负值与运算等于 0 的数的干扰
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }


}
