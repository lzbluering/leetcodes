package jianzhioffer;

/**
 * leetcodes
 * 数字在排序数组中出现的次数
 * @author lzz
 * @date 2019/12/16
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class Main42 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3};
        System.out.println(GetNumberOfK(arr, 3));
    }

    public static int GetNumberOfK(int[] nums, int K) {
        int first = firstSearch(nums, K);
        int last = firstSearch(nums, K+1);
        return (first == nums.length || nums[first] != K) ? 0 : last - first;
    }
    private static int firstSearch(int[] nums, int k) {
        int l = 0, h = nums.length;
        while(l < h){
            int m = l + (h-l)/2;
            if(nums[m] < k){
                l = m+1;
            }else {
                h = m;
            }
        }

        return l;
    }

}
/**
 * 解题思路：
 * 利用二分查找找出当前数字第一个在的下标，找出下一个比他大的数字的坐标，相减即是答案
 *
 * 注意：
 * 1、数字不存在时的情况
 * 2、数字在末尾的情况
 */