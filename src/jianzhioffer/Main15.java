package jianzhioffer;

/**
 * �������ظ�����
 *
 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ�
 * ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
 * Ҳ��֪��ÿ�������ظ����Ρ�
 * ���ҳ�����������һ���ظ������֡�
 *
 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 * numbers -> ����
 * length -> ���鳤��
 * duplication -> �ظ��������顾Ĭ�ϳ���Ϊ���鳤�ȡ�
 */
public class Main15 {

    public static boolean duplicate(int numbers[],int length, int [] duplication) {
        if(numbers == null || numbers.length < 2){
            return false;
        }
//        duplication = new int[1];
        for(int i=0; i<numbers.length; ++i){
            if(numbers[i] != i){
                if(numbers[numbers[i]] != numbers[i]){
                    int temp = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = temp;
                }else {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }

        return false;
    }
}
/**
 * ����˼·��
 * ���� ==> ����Ϊ n �������д��� 0 - n-1 �������������ظ�
 * �������飬�������ֲ������±꣬�򽫸��������Ӧ���±����ֻ���λ��
 * �����������ж�Ӧ�±��������±����ʱ�����ظ�����
 */
