package jianzhioffer;

/**
 * 求1+2+3+...+n
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Main12 {
    public int Sum_Solution(int n) {
        int ans = (int)Math.pow(n, 2) + n;
        return ans>>1;
    }
}
