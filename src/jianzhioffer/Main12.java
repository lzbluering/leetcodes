package jianzhioffer;

/**
 * ��1+2+3+...+n
 *
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 */
public class Main12 {
    public int Sum_Solution(int n) {
        int ans = (int)Math.pow(n, 2) + n;
        return ans>>1;
    }
}
