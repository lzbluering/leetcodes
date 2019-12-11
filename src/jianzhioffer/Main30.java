package jianzhioffer;

import java.util.HashMap;

/**
 * 复杂链表的复制
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
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
 * 解题思路：
 * 1、借助 HashMap<K, V> 映射，利用递归实现节点的复制，代码如上
 * 2、在每一个节点后面插入新的节点，然后在复制 radom ，最后拆分得到复制链表
 *
 */