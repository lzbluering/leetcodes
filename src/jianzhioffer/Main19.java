package jianzhioffer;

import java.util.BitSet;

/**
 * 字符流中第一个不重复的字符
 *
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Main19 {
    private String stringstream = "";

    //Insert one char from stringstream
    public void Insert(char ch){
        stringstream += ch;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        if(stringstream == null || stringstream.length() ==0){
            return '#';
        }

        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);

        for(char c : stringstream.toCharArray()){
            if(!bs1.get(c) && !bs2.get(c)){
                bs1.set(c);
            }else if(bs1.get(c) && !bs2.get(c)){
                bs2.set(c);
            }
        }

        for (int i = 0; i < stringstream.length(); i++) {
            char c = stringstream.charAt(i);
            if (bs1.get(c) && !bs2.get(c)){
                return c;
            }
        }

        return '#';
    }
}
/**
 * 解题思路：
 * 善用 java.util.BitSet 减少空间的浪费
 */