package jianzhioffer;

/**
 * leetcodes
 * ��ת����˳����
 * @author lzz
 * @date 2019/11/28
 *
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
 * ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
 * ���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
 * Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 */
public class Main11 {

    public static void main(String[] args) {
        System.out.println("=="+ReverseSentence("         ")+"==");
    }

    public static String ReverseSentence(String str) {
        if(str==null || str.length()==0){
            return str;
        }
        if(str.trim().equals("")){
            return str;
        }

        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=strs.length-1; i>=0; --i){
            sb.append(strs[i]);
            if(i!=0){
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}
/**
 * ����˼·��
 * 1��split() ����
 * 2��trim() ���� ���÷���ȥ�����ַ�����β�Ŀո񣬷���һ�����ַ���
 *
 * ���������" "��"     "��Ӧ�÷���ԭ�ַ���
 */