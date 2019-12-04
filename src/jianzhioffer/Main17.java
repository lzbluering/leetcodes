package jianzhioffer;

/**
 * ������ʽƥ��
 *
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
 * ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
 *
 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
 *
 * ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 */
public class Main17 {

    public boolean match(char[] str, char[] pattern) {
        int lenStr = str.length;
        int lenPat = pattern.length;

        boolean[][] dp = new boolean[lenStr+1][lenPat+1];
        dp[0][0] = true;
        for(int i=1; i<=lenPat; ++i){
            if(pattern[i-1] == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i=1; i<=lenStr; ++i){
            for(int j=1; j<=lenPat; ++j){
                if(str[i-1] == pattern[j-1] || pattern[j-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pattern[j-1] == '*'){
                    if(pattern[j-2] == str[i-1] || pattern[j-2] == '.'){
                        dp[i][j] |= dp[i][j-1]; //a* �������� a
                        dp[i][j] |= dp[i-1][j]; //a* ������� a
                        dp[i][j] |= dp[i][j-2]; //a* ������
                    }else{
                        dp[i][j] = dp[i][j-2]; //a* ����Ϊ��
                    }
                }
            }
        }

        return dp[lenStr][lenPat];
    }

}
