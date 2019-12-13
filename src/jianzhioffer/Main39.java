package jianzhioffer;

import java.util.BitSet;

/**
 * ��һ��ֻ����һ�ε��ַ�
 *
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
 */
public class Main39 {

    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() <= 0)
            return -1;

        int[] ans = new int[256];
        BitSet bset1 = new BitSet(256);
        BitSet bset2 = new BitSet(256);

        for(int i=0; i<str.length(); ++i)
            if(!bset1.get(str.charAt(i)))
                bset1.set(str.charAt(i));
            else if(!bset2.get(str.charAt(i)))
                bset2.set(str.charAt(i));
        for(int i=0; i<str.length(); ++i)
            if(!bset2.get(str.charAt(i)))
                return i;

        return -1;
    }

}
/**
 * ����˼·��
 * ���� hashmap ͳ��ÿһ���ַ����ֵĴ�������󷵻ص�һ��ֻ����һ�ε��ַ�
 *
 * �Ż���
 * 1���ַ��ķ�Χ���������ԣ������������hashmap
 public int FirstNotRepeatingChar(String str) {
     if(str == null || str.length() <= 0)
     return -1;

     int[] ans = new int[256];
     for(int i=0; i<str.length(); ++i)
        ans[str.charAt(i)]++;
     for(int i=0; i<str.length(); ++i)
        if(ans[str.charAt(i)] == 1)
            return i;

     return -1;
 }
 * 2���ó���ֻ���� 0��1������ ��˿������� Bit ���ٿռ�Ŀ������ﵽ�ռ���Ż�
 */