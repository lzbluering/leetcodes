package jianzhioffer;

import java.util.HashMap;

/**
 * 数组中出现数字超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
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
