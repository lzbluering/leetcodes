package jianzhioffer;

/**
 * �����л�����ڽڵ�
 *
 * ��Ŀ����
 * ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
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