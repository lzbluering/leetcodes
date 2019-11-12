import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 *
 * 给出?n?代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出?n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
 * 解题思路：
 * 一、回溯法
 * 当左括号数小于括号对数，可以选择加左括号
 * 当右括号数小于左括号数，可以选择加右括号
 */