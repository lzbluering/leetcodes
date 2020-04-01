package suanfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串
 *
 * 给定一个字符串?s?和一些长度相同的单词?words。找出 s 中恰好可以由?words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与?words 中的单词完全匹配，中间不能有其他字符，但不需要考虑?words?中单词串联的顺序。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main0030 {

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return ans;
        }

        Map<String, Integer> map = new HashMap<>();
        int oneWordsLen = words[0].length();
        int wordsLen = words.length;
        int sLen = s.length();
        for(int i=0; i<wordsLen; i++){
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }


        for(int i = 0; i < oneWordsLen; i++){
            int left = i, right = i;
            int count = 0;
            Map<String, Integer> tempMap = new HashMap<>();
            while (right + oneWordsLen <= sLen){
                String str = s.substring(right, right + oneWordsLen);
                right += oneWordsLen;
                if(!map.containsKey(str)){
                    count = 0;
                    left = right;
                    tempMap.clear();
                }else {
                    tempMap.put(str, tempMap.getOrDefault(str, 0)+1);
                    count++;
                    while (tempMap.getOrDefault(str, 0) > map.getOrDefault(str, 0)){
                        String strA = s.substring(left, left+oneWordsLen);
                        count--;
                        tempMap.put(strA, tempMap.getOrDefault(strA, 0)-1);
                        left += oneWordsLen;
                    }
                    if(count == wordsLen){
                        ans.add(left);
                    }
                }
            }
        }

        return ans;
    }

}
/**
 * 注意点：单词数组words都是相同长度的单次
 * 方法一：暴力遍历（HashMap）
 *          利用 hash，遍历字符串 s，每次取 words 单词组成句子长度的子串，字串划分单词比较 hash是否相同.
 * 方法二：滑动窗口
 *          利用滑动窗口，判断是否符合，如上
 */