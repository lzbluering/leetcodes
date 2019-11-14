package suanfa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main0015 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        int len = nums.length;
        if(nums == null || len < 3){
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len-2; i++) {
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]){
                        L++;
                    }
                    while (L<R && nums[R] == nums[R-1]){
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0){
                    L++;
                } else if (sum > 0){
                    R--;
                }
            }
        }
        return ans;
    }

}
/**
 * 解题思路：
 * 一、暴力破解
 * 显而易见，该方法时间复杂度过高
 *     public List<List<Integer>> threeSum(int[] nums) {
 *         List<List<Integer>> lists = new LinkedList<>();
 *         if(nums == null || nums.length<3){
 *             return lists;
 *         }
 *
 *         for(int i=0; i<nums.length; i++){
 *             for(int j=i+1; j<nums.length; j++){
 *                 for(int k=j+1; k<nums.length; k++){
 *                     if(nums[i]+nums[j]+nums[k] == 0){
 *                         List<Integer> list = new LinkedList<>();
 *                         list.add(nums[i]);
 *                         list.add(nums[j]);
 *                         list.add(nums[k]);
 *                         lists.add(list);
 *                     }
 *                 }
 *             }
 *         }
 *
 *         return lists;
 *     }
 * 二、回溯法
 * PS：采用回溯法而不采用分支限界法，原因是回溯法倾向于全体可行解，而分支限界法只是倾向于最优解之一
 *     private static List<List<Integer>> lists = new LinkedList<>();
 *     private static int k = 3;
 *     private static boolean[] isExist;
 *
 *     public static List<List<Integer>> threeSum(int[] nums) {
 *
 *         if(nums == null || nums.length<3){
 *             return lists;
 *         }
 *
 *         isExist = new boolean[nums.length];
 *         Arrays.sort(nums);
 *         backTrace(nums, 0);
 *
 *
 *         for(int i=0; i<lists.size(); i++){
 *             if(i+1<lists.size()){
 *                 int n = 0;
 *                 for(int j=0; j<3; j++){
 *                     if(lists.get(i).get(j) == lists.get(i+1).get(j)){
 *                         ++n;
 *                     }
 *                 }
 *                 if(n==3){
 *                     lists.remove(i);
 *                     i--;
 *                 }
 *             }
 *         }
 *         return lists;
 *     }
 *
 *     public static void backTrace(int[] nums, int index) {
 *         if(index == nums.length) {
 *             List<Integer> list = new LinkedList<>();
 *             int count = 0;
 *             int sum = 0;
 *             for (int i = 0; (i < index) && count<=3; i++) {
 *                 if (isExist[i]) {
 *                     list.add(nums[i]);
 *                     sum += nums[i];
 *                     count++;
 *                 }
 *             }
 *             if(count == 3 && sum==0){
 *                 lists.add(list);
 *             }
 *
 *         }else{
 *             isExist[index] = true;
 *             backTrace(nums, index+1);
 *             isExist[index] = false;
 *             backTrace(nums, index+1);
 *         }
 *     }
 * 三、排序数组后固定其中一个指针L，其余两个指针 l,r 指向该指针剩余尾部头尾
 *     1、若 nums[L] 大于零，则结束此次循环
 *     2、若指针 L>0 且 nums[L] = nums[L-1],会出现重复，跳过此次循环（L++）
 *     3、若 nums[l] + nums[r] + nums[L] = 0，则 l-1、r+1 并记录
 *     4、若 nums[l] + nums[r] + nums[L] > 0，则 l-1
 *     5、若 nums[l] + nums[r] + nums[L] < 0，则 r+1
 */