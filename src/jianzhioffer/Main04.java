package jianzhioffer;

import java.util.ArrayList;

/**
 * leetcodes
 *
 * @author lzz
 * @date 2019/11/19
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *              {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
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
 * 解题思路：
 * 计算每一个窗口的最大值并添加
 */