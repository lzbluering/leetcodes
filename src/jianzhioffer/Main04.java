package jianzhioffer;

import java.util.ArrayList;

/**
 * leetcodes
 *
 * @author lzz
 * @date 2019/11/19
 *
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 *
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
 * �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 *              {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 *
 */
public class Main04 {

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        System.out.println(maxInWindows(num, 6).toString());
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();

        if(num.length < size || size==0){
            return ans;
        }

        for(int i=size-1; i<num.length; ++i){
            ans.add(maxNum(num, i-size+1, size));
        }

        return ans;
    }

    private static int maxNum(int[] num, int index, int size){
        int max = num[index];
        for(int i = index+1; i<index+size; ++i){
            max = Math.max(max, num[i]);
        }

        return max;
    }

}
/**
 * ����˼·��
 * ����ÿһ�����ڵ����ֵ�����
 */