/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main0007 {

    public static void main(String[] args) {
        System.out.printf(reverse(-1234567899)+"");
    }

    public static int reverse(int x) {

        String max = Integer.toString(Integer.MAX_VALUE);
        String min = Integer.toString(Integer.MIN_VALUE);

        String str = toTurn(x);
        int result = 0;
        try{
            result = Integer.parseInt(str);
        }catch (Exception e){
            return result;
        }
        return result;
    }

    private static String toTurn(int x){
        StringBuilder sb = new StringBuilder();
        if(x < 0){
            sb.append('-');
            x = 0-x;
        }

        String str = Integer.toString(x);
        for(int i=str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}
