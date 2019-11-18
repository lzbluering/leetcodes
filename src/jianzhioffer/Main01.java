package jianzhioffer;

import java.util.Scanner;

/**
 * ������
 *
 * ��Ŀ����
 * ����һ������Ϊn�����ӣ�������Ӽ���m�Σ�m��n����������n>1����m>1����ÿ�����ӵĳ��ȼ�Ϊk[0],k[1],...,k[m]������k[0]xk[1]x...xk[m]���ܵ����˻��Ƕ��٣����磬�����ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ������˻���18��
 * ��������:
 * ����һ����n����������档��2 <= n <= 60��
 * �������:
 * ����𰸡�
 * ʾ��1
 * ����
 * 8
 * ���
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
 * ����˼·��
 * ���õݹ�
 * ���������ע��ȡֵ n >= 2 ��m > 1
 */