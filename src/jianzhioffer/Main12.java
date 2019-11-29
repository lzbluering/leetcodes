package jianzhioffer;

import java.util.Arrays;

/**
 * leetcodes
 * �˿���˳��
 * @author lzz
 * @date 2019/11/28
 *
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
 * ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
 * ������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
 * �����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ����
 * ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ� ����������˳�Ӿ����true����������false��Ϊ�˷������,�������Ϊ��С����0��
 */
public class Main12 {

    public static void main(String[] args) {
        int[] numbers = {0,1,0,2,7};
        System.out.println(isContinuous(numbers));
    }

    public static boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length < 5){
            return false;
        }
        Arrays.sort(numbers);
        int zero = 0;
        int i=0;
        for(; i<numbers.length; ++i){
            if(numbers[i] == 0){
                zero++;
            }else{
                break;
            }
        }
        int pre = -1;
        int index = 0;
        for(; i<numbers.length; ++i){
            if(pre == -1){
                pre = numbers[i];
            }else{
                if(pre != numbers[i]-1 && zero > 0){
                    zero--;
                    ++pre;
                    --i;
                }else if(pre == numbers[i]-1){
                    ++pre;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

}
