package jianzhioffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 *
 * 输入n个整数，找出其中最小的K个数。
 *
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Main34 {

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,8,7,6,4};
        ArrayList<Integer> list = GetLeastNumbers_Solution(nums, 5);
        System.out.println(list.toString());
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }

}
/**
 * 解题思路：
 * java.util.PriorityQueue -> 优先权队列
 * 根据优先权队列维护一个最大堆，若最大堆超出 k ，则抛出最大堆中最大的数，直到遍历一遍后返回 PriorityQueue 中剩余的 k 个数即可
 */