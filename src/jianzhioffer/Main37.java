package jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * �������ų���С����
 *
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 *
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 */
public class Main37 {

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";

        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++)
            nums[i] = numbers[i] + "";
        Arrays.sort(nums, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
//        Arrays.sort(nums, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o1+o2).compareTo(o2+o1);
//            }
//        });
        String ans = "";
        for (String str : nums)
            ans += str;
        return ans;
    }

}
