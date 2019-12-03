package jianzhioffer;

/**
 * 数组中重复的数
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * numbers -> 数组
 * length -> 数组长度
 * duplication -> 重复数字数组【默认长度为数组长度】
 */
public class Main15 {

    public static boolean duplicate(int numbers[],int length, int [] duplication) {
        if(numbers == null || numbers.length < 2){
            return false;
        }
//        duplication = new int[1];
        for(int i=0; i<numbers.length; ++i){
            if(numbers[i] != i){
                if(numbers[numbers[i]] != numbers[i]){
                    int temp = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = temp;
                }else {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }

        return false;
    }
}
/**
 * 解题思路：
 * 分析 ==> 长度为 n 的数组中存在 0 - n-1 的整数，存在重复
 * 遍历数组，若该数字不等于下标，则将该数字与对应的下标数字互换位置
 * 当互换过程中对应下标数字与下标相等时，返回该数字
 */
