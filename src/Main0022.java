import java.util.LinkedList;
import java.util.List;

/**
 * ��������
 *
 * ����?n?�����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
 *
 * ���磬����?n = 3�����ɽ��Ϊ��
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/generate-parentheses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Main0022 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        if(n<1){
            return list;
        }
        backTrack(list, "", 0, 0, n);

        return list;
    }

    private void backTrack(List<String> list, String str, int left, int right, int len) {

        if(str.length() == len*2){
            list.add(str);
            return;
        }

        if(left > right){
            backTrack(list, str+')', left, right+1, len);
        }
        if(left < len){
            backTrack(list, str+'(', left+1, right, len);
        }
    }
}
/**
 * ����˼·��
 * һ�����ݷ�
 * ����������С�����Ŷ���������ѡ���������
 * ����������С����������������ѡ���������
 */