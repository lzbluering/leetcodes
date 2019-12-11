package jianzhioffer;

import java.util.HashMap;

/**
 * ��������ĸ���
 *
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 */
public class Main30 {

    public static RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        return tokV(pHead, map);
    }

    private static RandomListNode tokV(RandomListNode root, HashMap map){
        if(root == null)
            return null;
        if(!map.containsKey(root)){
            RandomListNode temp = new RandomListNode(root.label);
            map.put(root, temp);
            temp.next = tokV(root.next, map);
            temp.random = tokV(root.random, map);
        }
        return (RandomListNode) map.get(root);
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
/**
 * ����˼·��
 * 1������ HashMap<K, V> ӳ�䣬���õݹ�ʵ�ֽڵ�ĸ��ƣ���������
 * 2����ÿһ���ڵ��������µĽڵ㣬Ȼ���ڸ��� radom ������ֵõ���������
 *
 */