package jianzhioffer;

import java.util.BitSet;

/**
 * �ַ����е�һ�����ظ����ַ�
 *
 * ��Ŀ����
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 * ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 *
 * �������:
 * �����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
 */
public class Main19 {
    private String stringstream = "";

    //Insert one char from stringstream
    public void Insert(char ch){
        stringstream += ch;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        if(stringstream == null || stringstream.length() ==0){
            return '#';
        }

        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);

        for(char c : stringstream.toCharArray()){
            if(!bs1.get(c) && !bs2.get(c)){
                bs1.set(c);
            }else if(bs1.get(c) && !bs2.get(c)){
                bs2.set(c);
            }
        }

        for (int i = 0; i < stringstream.length(); i++) {
            char c = stringstream.charAt(i);
            if (bs1.get(c) && !bs2.get(c)){
                return c;
            }
        }

        return '#';
    }
}
/**
 * ����˼·��
 * ���� java.util.BitSet ���ٿռ���˷�
 */