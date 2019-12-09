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
/**
 * ����˼·��
 * 1�����ÿ���ָ�� fast��slow �����ڻ���
 *     �� fast == slow ʱ��ʹָ�� fast ��ͷ�ڵ����α�����slow ���������������α����������ٴ���������ǻ������
 *
 * ԭ��
 * 1�����壺
 *     x ������Ϊ���ĳ��ȡ�
 *     c �ǻ��ĳ��ȡ�
 *     a �ǻ�����ڵ�������ľ��롢
 *     b �������㵽����ڵľ��롢
 *     m ����ָ��(һ����һ���ڵ�)�ڻ��ߵ�Ȧ����
 *     n �ǿ�ָ��(һ���������ڵ�)�ڻ��ߵ�Ȧ��
 * 2��֤����
 * fast = x + nc + a
 * slow = x + mc + a
 * fast = 2slow
 *      ��
 * x = (n-2m)c - a
 * ���Ե� n-2m = 1 ʱ�� x == c-a,�� x == b
 * ��ʱ���� fast��slow �ڻ��������
 */