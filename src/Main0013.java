import java.util.HashMap;

/**
 * 罗马数字转整数
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main0013 {

    public static void main(String[] args) {
        System.out.printf(romanToInt("III")+"");
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int result = 0;
        int i = 0;
        for(i = s.length()-1; i>=0; --i){
            int current = map.get(s.charAt(i));
            int pre = (i-1 >= 0) ? map.get(s.charAt(i-1)) : 0;
            if(current > pre){
                result = result+current-pre;
                --i;
            }else {
                result += current;
            }
        }
        return result;
    }

}
/**
 * 解题思路：
 * 一、利用hash表，找出对应的整数，相加
 *     public static int romanToInt(String s) {
 *         HashMap<String, Integer> map = new HashMap<>();
 *         map.put("M", 1000);
 *         map.put("CM", 900);
 *         map.put("D", 500);
 *         map.put("CD", 400);
 *         map.put("C", 100);
 *         map.put("XC", 90);
 *         map.put("L", 50);
 *         map.put("XL", 40);
 *         map.put("X", 10);
 *         map.put("IX", 9);
 *         map.put("V", 5);
 *         map.put("IV", 4);
 *         map.put("I", 1);
 *
 *         int result = 0;
 *         for(int i = 0; i<s.length(); ++i){
 *             if(i+1<s.length() && map.containsKey(s.substring(i, i+2))){
 *                 result += map.get(s.substring(i, i+2));
 *                 ++i;
 *             }else{
 *                 result += map.get(s.substring(i, i+1));
 *             }
 *         }
 *         return result;
 *     }
 * 二、优化思路
 * 判断每一个字符对应的整数
 *   1、下一个字符大于当前字符代表的整数，减去当前字符加上下一个字符，跳过下一个字符
 *   2、下一个字符小于当前字符代表的整数，加上当前字符
 * 重复返回结果，注意处理最后一个字符
 */
