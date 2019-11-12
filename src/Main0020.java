import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * ��Ч������
 *
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'?���ַ������ж��ַ����Ƿ���Ч��
 *
 * ��Ч�ַ��������㣺
 *
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ע����ַ����ɱ���Ϊ����Ч�ַ�����
 *
 * ʾ�� 1:
 *
 * ����: "()"
 * ���: true
 * ʾ��?2:
 *
 * ����: "()[]{}"
 * ���: true
 * ʾ��?3:
 *
 * ����: "(]"
 * ���: false
 * ʾ��?4:
 *
 * ����: "([)]"
 * ���: false
 * ʾ��?5:
 *
 * ����: "{[]}"
 * ���: true
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/valid-parentheses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Main0020 {

    public static void main(String[] args) {
        System.out.println(isValid("(){}[{(})]"));
    }

    public static boolean isValid(String s) {
        if(s==null || s.length() < 1){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(stack.isEmpty()){
                if(temp == ')' || temp == ']'|| temp == '}'){
                    return false;
                }
                stack.push(temp);
            }else{
                char sTemp = stack.peek();
                if(sTemp == '{'){
                    if(temp == '}'){
                        stack.pop();
                    }else if(temp == ']' || temp == ')'){
                        return false;
                    }else{
                        stack.push(temp);
                    }
                }else if(sTemp == '['){
                    if(temp == ']'){
                        stack.pop();
                    }else if(temp == '}' || temp == '{' || temp == ')'){
                        return false;
                    }else{
                        stack.push(temp);
                    }
                }else{
                    if(temp == ')'){
                        stack.pop();
                    }else if(temp == '}' || temp == '{' || temp == ']' || temp == '['){
                        return false;
                    }else{
                        stack.push(temp);
                    }
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }

}
