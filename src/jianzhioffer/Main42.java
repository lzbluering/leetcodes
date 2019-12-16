package jianzhioffer;

/**
 * leetcodes
 * ���������������г��ֵĴ���
 * @author lzz
 * @date 2019/12/16
 *
 * ͳ��һ�����������������г��ֵĴ�����
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
 * ����˼·��
 * ���ö��ֲ����ҳ���ǰ���ֵ�һ���ڵ��±꣬�ҳ���һ������������ֵ����꣬������Ǵ�
 *
 * ע�⣺
 * 1�����ֲ�����ʱ�����
 * 2��������ĩβ�����
 */