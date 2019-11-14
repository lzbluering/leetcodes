package suanfa;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main0016 {

    public static void main(String[] args) {
        int[] arr = {-3,0,1,2};
        System.out.println(threeSumClosest(arr, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        int num = Math.max(ans,target)-Math.min(ans,target);
        for(int i=0; i<nums.length-2; i++){
            int r = nums.length-1;
            int l = i+1;
            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                int temp = Math.max(sum,target)-Math.min(sum,target);
                if(temp <= num){
                    ans = sum;
                    num = temp;
                }
                if(sum-target>0){
                    --r;
                }else {
                    ++l;
                }
            }
        }

        return ans;
    }

}
/**
 * 解题思路：
 * 排序后单指针+双指针循环
 */