package suanfa;

import sun.java2d.windows.GDIWindowSurfaceData;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main0017 {
    private static Map<Character, char[]> map = new HashMap<>();
    private static int[] nums;
    private static List<String> list = new LinkedList();

    public static List<String> letterCombinations(String digits) {
        nums = new int[digits.length()];
        map.put('2', "abc".toCharArray());
        map.put('3', "def".toCharArray());
        map.put('4', "ghi".toCharArray());
        map.put('5', "jkl".toCharArray());
        map.put('6', "mno".toCharArray());
        map.put('7', "pqrs".toCharArray());
        map.put('8', "tuv".toCharArray());
        map.put('9', "wxyz".toCharArray());

        if(digits == null || digits.length()<1){
            return list;
        }
        backTrace(0, digits);
        return list;
    }

    private static void backTrace(int index, String str){
        if(index == str.length()){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length(); i++){
                sb.append(map.get(str.charAt(i))[nums[i]]);
            }
            list.add(sb.toString());
            return;
        }

        for(int i=0; i<map.get(str.charAt(index)).length; i++){
            nums[index] = i;
            backTrace(index+1, str);
        }
    }
}
/**
 * 解题思路：
 * 回溯法
 */