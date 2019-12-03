package jianzhioffer;

/**
 * ���ַ���ת��������
 *
 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 * ��������:
 * ����һ���ַ���,����������ĸ����,����Ϊ��
 * �������:
 * ����ǺϷ�����ֵ����򷵻ظ����֣����򷵻�0
 *
 * ʾ��1
 * ����
 * +2147483647
 * ���
 * 2147483647
 *
 * ʾ��2
 * a312
 * 0
 */
public class Main14 {
    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483649"));
    }

    public static int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }

        int index = 0;
        boolean flag = true;
        long ans = 0;
        while(index < str.length()){
            char c = str.charAt(index);
            if(index == 0){
                if(c == '+'){
                    flag = true;
                }else if(c == '-'){
                    flag = false;
                }else if(c >= '0' && c <='9'){
                    ans += (c-'0')*Math.pow(10, str.length()-1-index);
                }else{
                    return 0;
                }
            }else{
                if(c >= '0' && c <='9'){
                    ans += (c-'0')*Math.pow(10, str.length()-1-index);
                }else{
                    return 0;
                }
            }
            index++;
        }

        ans = flag ? ans : -ans;
        return (ans<Integer.MIN_VALUE || ans>Integer.MAX_VALUE) ? 0 : (int)ans;
    }
}
/**
 * ����˼·��
 * 1�����ȿ��ǵ���λ�������ŵ����
 * 2�����Ǽ������������ [Integer.MIN_VALUE, Integer.MAX_VALUE] ��������
 */