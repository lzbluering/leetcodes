package suanfa;

/**
 * ʵ��?strStr()?������
 *
 * ����һ��?haystack �ַ�����һ�� needle �ַ������� haystack �ַ������ҳ� needle �ַ������ֵĵ�һ��λ�� (��0��ʼ)����������ڣ��򷵻�? -1��
 *
 * ʾ�� 1:
 *
 * ����: haystack = "hello", needle = "ll"
 * ���: 2
 * ʾ�� 2:
 *
 * ����: haystack = "aaaaa", needle = "bba"
 * ���: -1
 * ˵��:
 *
 * ��?needle?�ǿ��ַ���ʱ������Ӧ������ʲôֵ�أ�����һ���������кܺõ����⡣
 *
 * ���ڱ�����ԣ���?needle?�ǿ��ַ���ʱ����Ӧ������ 0 ������C���Ե�?strstr()?�Լ� Java��?indexOf()?���������
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/implement-strstr
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Main0028 {

    public int strStr(String haystack, String needle) {

        int len = needle.length();
        if(len == 0){
            return 0;
        }
        for(int i=0; i<=haystack.length()-len; i++){
            if(haystack.charAt(i) == needle.charAt(0) && haystack.substring(i, i+len).equals(needle)){
                return i;
            }
        }

        return -1;
    }

}
/**
 * ����˼·��
 * ��������
 * ����һ�������ƽ�
 * ���������Ż�
 * ���������Ƚ��Ӵ�hash
 */