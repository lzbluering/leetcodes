package jianzhioffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * ��С��K����
 *
 * ����n���������ҳ�������С��K������
 *
 * ��������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
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
 * ����˼·��
 * java.util.PriorityQueue -> ����Ȩ����
 * ��������Ȩ����ά��һ�����ѣ������ѳ��� k �����׳���������������ֱ������һ��󷵻� PriorityQueue ��ʣ��� k ��������
 */