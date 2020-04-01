package suanfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �������е��ʵ��Ӵ�
 *
 * ����һ���ַ���?s?��һЩ������ͬ�ĵ���?words���ҳ� s ��ǡ�ÿ�����?words �����е��ʴ����γɵ��Ӵ�����ʼλ�á�
 *
 * ע���Ӵ�Ҫ��?words �еĵ�����ȫƥ�䣬�м䲻���������ַ���������Ҫ����?words?�е��ʴ�����˳��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * �����[0,9]
 * ���ͣ�
 * ������ 0 �� 9 ��ʼ���Ӵ��ֱ��� "barfoo" �� "foobar" ��
 * �����˳����Ҫ, [9,0] Ҳ����Ч�𰸡�
 * ʾ�� 2��
 *
 * ���룺
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * �����[]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
 * ע��㣺��������words������ͬ���ȵĵ���
 * ����һ������������HashMap��
 *          ���� hash�������ַ��� s��ÿ��ȡ words ������ɾ��ӳ��ȵ��Ӵ����ִ����ֵ��ʱȽ� hash�Ƿ���ͬ.
 * ����������������
 *          ���û������ڣ��ж��Ƿ���ϣ�����
 */