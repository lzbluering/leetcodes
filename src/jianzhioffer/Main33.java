package jianzhioffer;

import java.util.HashMap;

/**
 * �����г������ֳ���һ�������
 *
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 *
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
 * ��������������0��
 */
public class Main33 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer num : array){
            if(map.containsKey(num))
                map.put(num, map.get(num)+1);
            else
                map.put(num, 1);
        }
        int size = array.length/2;
        for(Integer key : map.keySet()){
            if(map.get(key) > size)
                return key;
        }
        return 0;
    }

}
