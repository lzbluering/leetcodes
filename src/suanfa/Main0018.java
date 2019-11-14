package suanfa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main0018 {

    private static List<List<Integer>> lists = new LinkedList<>();

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums == null || nums.length<4){
            return lists;
        }

        Arrays.sort(nums);
        int len = nums.length;
        if(nums[0]*4>target || nums[len-1]*4 < target){
            return lists;
        }

        int start = 0, end = nums.length-1;
        while(end-start >= 3){
            int start2 = start+1, end2 = end-1;
            while(start2<end2){
                if(nums[start]+nums[start2]+nums[end2]+nums[end] == target){
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[start]);
                    list.add(nums[start2]);
                    list.add(nums[end2]);
                    list.add(nums[end]);
                    lists.add(list);
                    start2++;
                    if(nums[start2] == nums[start2-1]){
                        start2++;
                    }
                    end2--;
                    if(nums[end2] == nums[end2+1]){
                        end2--;
                    }
                }else if(nums[start]+nums[start2]+nums[end2]+nums[end] < target){
                    start2++;
                    if(nums[start2] == nums[start2-1]){
                        start2++;
                    }
                }else {
                    end2--;
                    if(nums[end2] == nums[end2+1]){
                        end2--;
                    }
                }
            }

            if(nums[start]*2 + nums[end]*2>=target){
                end--;
                if(nums[end] == nums[end+1]){
                    end--;
                }
            }else {
                start++;
                if(nums[start] == nums[start-1]){
                    start++;
                }
            }
        }

        return lists;
    }


}
/**
 * 解题思路：
 * 滑动窗口
 */