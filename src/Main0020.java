import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'?的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例?2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例?3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例?4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例?5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
