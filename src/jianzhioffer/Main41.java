package jianzhioffer;

/**
 * leetcodes
 * 两个链表的第一个公共结点
 * @author lzz
 * @date 2019/12/16
 *
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Main41 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

}
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * 解题思路：
 * 设 第一个链表长度 a+c ，第二个链表长度 b+c (a代表第一个链表不相交的长度，b代表第二个链表不相交的长度，c代表相交的长度)
 * 则 a+c+b == b+c+a
 * 解法也包含了两个链表不相交的情况 ==> 即 c = 0 时
 */