package suanfa;

/**
 * 正则表达式匹配
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main0010 {

    private static Boolean[][] dp;

    public static void main(String[] args) {
        System.out.printf(isMatch("abc", "a.c*")+"");
    }

    public static boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];
        return isMyMatch(s, p, 0, 0);
    }

    public static boolean isMyMatch(String s, String p, int m, int n) {
        if(dp[m][n] != null){
            return dp[m][n];
        }
        if(n>=p.length()){
            dp[m][n] = m>=s.length() ? true : false;
            return dp[m][n];
        }
        boolean firstBoolean = m<s.length() && (s.charAt(m) == p.charAt(n) || p.charAt(n) == '.');
        if(n+1 < p.length() && p.charAt(n+1) == '*'){
            dp[m][n] = isMyMatch(s, p, m, n+2) || firstBoolean && isMyMatch(s, p, m+1, n);

        }else{
            dp[m][n] = firstBoolean && isMyMatch(s, p, m+1, n+1);
        }
        return dp[m][n];
    }

}
/**
 * 解题思路：
 * 一、暴力破解思路解析
 * 若是常规的两个字符串对比，仅仅有'.'匹配符
 *     public static boolean isMyMatch(String s, String p, int m, int n) {
 *         if(n>=p.length()){
 *             return m>=s.length() ? true : false;
 *         }
 *         boolean firstBoolean = m<s.length() && (s.charAt(m) == p.charAt(n) || p.charAt(n) == '.');
 *         return firstBoolean && isMyMatch(s, p, m+1, n+1);
 *     }
 * 此时考虑'*'匹配符：
 *     public static boolean isMyMatch(String s, String p, int m, int n) {
 *         if(n>=p.length()){
 *             return m>=s.length() ? true : false;
 *         }
 *         boolean firstBoolean = m<s.length() && (s.charAt(m) == p.charAt(n) || p.charAt(n) == '.');
 *         if(n+1 < p.length() && p.charAt(n+1) == '*'){
 *             return isMyMatch(s, p, m, n+2) || firstBoolean && isMyMatch(s, p, m+1, n);
 *         }
 *         return firstBoolean && isMyMatch(s, p, m+1, n+1);
 *     }
 *     即当前匹配正则表达式字符后一位是'*',则考虑：
 *         1、当前正则表达式字符若相同则继续与下一位字符匹配
 *         2、当前正则表达式字符若不相同则当前字符跳过'*'字符继续与正则表达式字符匹配
 * 二、动态规划
 * 添加备忘录dp[i][j],记录s[i]与p[j]是否匹配的状态：
 *     代码如上
 */