package suanfa;

/**
 * 盛最多水的容器
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main0011 {
    public static int maxArea(int[] height) {
        int maxCurrent = 0;
        int start = 0, end = height.length-1;

        while (start != end){
            maxCurrent = Math.max(maxCurrent, (end-start)*Math.min(height[start], height[end]));
            if(height[start] >= height[end]){
                end--;
            }else {
                start++;
            }
        }

        return maxCurrent;
    }
}
/**
 * 解题思路：
 * 一、暴力破解法
 *     public static int maxArea(int[] height) {
 *         int maxCurrent = 0;
 *         for(int i=1; i<height.length; i++){
 *             for(int j=0; j<i; j++){
 *                 int temp = Math.min(height[j], height[i]) * (i-j);
 *                 maxCurrent = Math.max(maxCurrent, temp);
 *             }
 *         }
 *         return maxCurrent;
 *     }
 * 二、优化思路：双指针法（滑动窗口）
 * 1、双指针start、end分别位于数组头尾，记录当前面积值areaCurrent
 * 2、指针指向的数值小的向内移动，记录此时面积值，并比较赋值给areaCurrent
 * 3、重复步骤2直至start==end，返回areaCurrent
 */
