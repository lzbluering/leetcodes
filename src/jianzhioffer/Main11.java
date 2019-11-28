package jianzhioffer;

/**
 * leetcodes
 * 旋转单词顺序列
 * @author lzz
 * @date 2019/11/28
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
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
 * 解题思路：
 * 1、split() 方法
 * 2、trim() 方法 ：该方法去掉了字符串首尾的空格，返回一个新字符串
 *
 * 极端情况：" "、"     "，应该返回原字符串
 */