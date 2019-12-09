package jianzhioffer;

/**
 * 链表中环的入口节点
 *
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Main20 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                fast = pHead;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                if(fast == slow){
                    return fast;
                }
            }
        }

        return null;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
/**
 * 解题思路：
 * 1、设置快慢指针 fast、slow 若存在环：
 *     当 fast == slow 时，使指针 fast 从头节点依次遍历，slow 继续从相遇点依次遍历，两者再次相遇点既是环的入口
 *
 * 原理：
 * 1、定义：
 *     x 是链表不为环的长度、
 *     c 是环的长度、
 *     a 是环的入口到相遇点的距离、
 *     b 是相遇点到环入口的距离、
 *     m 是慢指针(一次走一个节点)在环走的圈数、
 *     n 是快指针(一次走两个节点)在环走的圈数
 * 2、证明：
 * fast = x + nc + a
 * slow = x + mc + a
 * fast = 2slow
 *      ↓
 * x = (n-2m)c - a
 * 所以当 n-2m = 1 时， x == c-a,即 x == b
 * 此时正好 fast、slow 在环入口相遇
 */