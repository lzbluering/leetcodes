package jianzhioffer;

/**
 * leetcodes
 * ����ת�ַ���
 * @author lzz
 * @date 2019/11/28
 *
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ������������
 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
 * �ǲ��Ǻܼ򵥣�OK���㶨����
 */
public class Main10 {

    public static void main(String[] args) {
        System.out.println(LeftRotateString("", 2));
    }

    public static String LeftRotateString(String str,int n) {
        if(str==null || str.length()<=1){
            return str;
        }

        if(n>=str.length()){
            n %= str.length();
        }

        String s1 = str.substring(n);
        String s2 = "";
        if(n != 0){
            s2 = str.substring(0,n);
        }

        return s1+s2;
    }

}
