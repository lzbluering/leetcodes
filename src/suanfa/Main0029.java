package suanfa;

/**
 * �������
 *
 * ��������������������?dividend?�ͳ���?divisor�������������Ҫ��ʹ�ó˷��������� mod �������
 *
 * ���ر�����?dividend?���Գ���?divisor?�õ����̡�
 *
 * ʾ��?1:
 *
 * ����: dividend = 10, divisor = 3
 * ���: 3
 * ʾ��?2:
 *
 * ����: dividend = 7, divisor = -3
 * ���: -2
 * ˵��:
 *
 * �������ͳ�����Ϊ 32 λ�з���������
 * ������Ϊ?0��
 * �������ǵĻ���ֻ�ܴ洢 32 λ�з�������������ֵ��Χ�� [?231,? 231?? 1]�������У�����������������򷵻� 231?? 1��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/divide-two-integers
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Main0029 {

    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) divisor = -divisor;
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;
    }

}
/**
 * ����˼·��
 * ���ó����������ơ�ע�����
 */