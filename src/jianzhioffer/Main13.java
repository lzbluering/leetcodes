package jianzhioffer;

/**
 * ���üӼ��˳����ӷ�
 *
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 */
public class Main13 {

    public int Add(int num1,int num2) {
        if(num2 == 0){
            return num1;
        }
        int a = num1 ^ num2;
        int b = num1 & num2;
        b = b << 1;

        return Add(a, b);
    }
}
