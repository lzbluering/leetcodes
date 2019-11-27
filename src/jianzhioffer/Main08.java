package jianzhioffer;

import java.util.ArrayList;

/**
 * 和为 S 的连续正数序列
 *
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class Main08 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrs = FindContinuousSequence(5);
        for(int i=0; i<arrs.size(); ++i){
            System.out.println(arrs.get(i).toString());
        }
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrs = new ArrayList<>();
        if(sum < 3){
            return arrs;
        }
        int start = 1, end = 2;
        int temp = 3;
        int endS = (sum+1)/2;
        while(start < end && start<endS){
            if(temp == sum){
                ArrayList<Integer> arr = new ArrayList<>();
                for(int i=start; i<=end; ++i){
                    arr.add(i);
                }
                arrs.add(arr);
                temp -= start;
                start++;
            }else if(temp<sum){
                end++;
                temp += end;
            }else{
                temp -= start;
                start++;
            }
        }

        return arrs;
    }
}
/**
 * 解题思路：
 * 利用双指针，制造滑动窗口，判断窗口中的数字是否符合
 */