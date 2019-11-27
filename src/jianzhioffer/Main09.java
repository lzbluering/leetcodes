package jianzhioffer;

import java.util.ArrayList;

/**
 * 和为 S 的两个数字
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Main09 {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};

        System.out.println(FindNumbersWithSum(array, 5));
    }

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(array == null || array.length < 2){
            return arr;
        }

        int start = 0, end = array.length-1;
        int temp = Integer.MAX_VALUE;
        int resultS = -1,resultE = -1;
        while(start < end){
            if(array[start] + array[end] == sum){
                if(array[start] * array[end] <= temp){
                    resultS = start;
                    resultE = end;
                    temp = array[start] * array[end];
                }
                start++;
                end--;
            }else if(array[start] + array[end] > sum){
                end--;
            }else {
                start++;
            }
        }
        if(resultE != -1){
            arr.add(array[resultS]);
            arr.add(array[resultE]);
        }

        return arr;
    }

}
