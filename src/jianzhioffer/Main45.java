package jianzhioffer;

import java.util.BitSet;

/**
 * leetcodes
 * ������ֻ����һ�ε�����
 * @author lzz
 * @date 2019/12/16
 *
 * һ�����������������������֮�⣬���������ֶ����������Ρ�
 * ��д�����ҳ�������ֻ����һ�ε����֡�
 *
 * //num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
 * //��num1[0],num2[0]����Ϊ���ؽ��
 */
public class Main45 {

    public static void main(String[] args) {
        int num = -7^5;
        num &= -num;
        System.out.println(-num & 5);
    }

    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        //���֮�� diff ����������û����ͬ���ֵ��������������ͬ�������� 0 ��
        for (int num : nums){
            diff ^= num;
        }

        //ʹ diff ֵ��Ϊ��ֵ������ֵ��
        diff &= -diff;

        for (int num : nums) {
            //������������һ������ diff�ľ���ֵ ������֮����� 0�� ��һ���������㣬���Ǹ�����ֵ ��������� 0
            if ((num & diff) == 0){
                //�ų����и�ֵ��������� 0 �����ĸ���
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }


}
