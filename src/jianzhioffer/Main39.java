package jianzhioffer;

import java.util.BitSet;

/**
 * 第一个只出现一次的字符
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Main39 {

    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() <= 0)
            return -1;

        int[] ans = new int[256];
        BitSet bset1 = new BitSet(256);
        BitSet bset2 = new BitSet(256);

        for(int i=0; i<str.length(); ++i)
            if(!bset1.get(str.charAt(i)))
                bset1.set(str.charAt(i));
            else if(!bset2.get(str.charAt(i)))
                bset2.set(str.charAt(i));
        for(int i=0; i<str.length(); ++i)
            if(!bset2.get(str.charAt(i)))
                return i;

        return -1;
    }

}
/**
 * 解题思路：
 * 利用 hashmap 统计每一个字符出现的次数，最后返回第一个只出现一次的字符
 *
 * 优化：
 * 1、字符的范围具有特殊性，利用数组代替hashmap
 public int FirstNotRepeatingChar(String str) {
     if(str == null || str.length() <= 0)
     return -1;

     int[] ans = new int[256];
     for(int i=0; i<str.length(); ++i)
        ans[str.charAt(i)]++;
     for(int i=0; i<str.length(); ++i)
        if(ans[str.charAt(i)] == 1)
            return i;

     return -1;
 }
 * 2、该场景只存在 0、1、更多 因此可以利用 Bit 减少空间的开销，达到空间的优化
 */