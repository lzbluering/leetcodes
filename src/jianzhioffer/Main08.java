package jianzhioffer;

import java.util.ArrayList;

/**
 * ��Ϊ S ��������������
 *
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
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
 * ����˼·��
 * ����˫ָ�룬���컬�����ڣ��жϴ����е������Ƿ����
 */