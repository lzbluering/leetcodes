package jianzhioffer;

/**
 * �����������ĺ����������
 *
 * ��Ŀ����
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 */
public class Main28 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null)
            return true;
        if(sequence.length == 0)
            return false;

        return isSearchTree(sequence, 0, sequence.length-1);
    }

    public boolean isSearchTree(int [] sequence, int start, int end) {
        if(start >= end)
            return true;

        int i = start;
        while(i<end){
            if(sequence[i] < sequence[end])
                ++i;
            else
                break;
        }
        int index = i;
        while(i<end){
            if(sequence[i] > sequence[end])
                ++i;
            else
                break;
        }
        return (i == end ? true : false) & isSearchTree(sequence, start, i-1) & isSearchTree(sequence, i, end-1);
    }
}
/**
 * ���������
 * 1���������������ԣ����ڵ���ߵĽڵ㶼�ȸ��ڵ�С�����ڵ��ұߵĽڵ㶼�ȸ��ڵ��
 * 2������Ϊ�մ�������ĺ������
 * 3�����鳤��Ϊ�㲻���ڶ�Ӧ�Ķ���������
 * 4����������ǣ����Ҹ�
 */