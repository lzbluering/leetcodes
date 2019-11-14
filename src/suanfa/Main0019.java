package suanfa;

/**
 * ɾ������ĵ�����N���ڵ�
 *
 * ����һ������ɾ������ĵ�����?n?���ڵ㣬���ҷ��������ͷ��㡣
 *
 * ʾ����
 *
 * ����һ������: 1->2->3->4->5, �� n = 2.
 *
 * ��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
 * ˵����
 *
 * ������ n?��֤����Ч�ġ�
 *
 * ���ף�
 *
 * ���ܳ���ʹ��һ��ɨ��ʵ����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Main0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode p = head;

        for(int i=0; i<n-1; i++){
            p = p.next;
        }
        if(p.next == null){
            return head.next;
        }
        ListNode pNext = head;
        p = p.next;
        while(p.next!=null){
            p=p.next;
            pNext=pNext.next;
        }

        pNext.next = pNext.next.next;

        return head;
    }

}
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
/**
 * ����˼·��
 * 1��˫ָ�룬��һ��ָ�� p �ȱ��� n����ʱ��� p.next==null ���ʾɾ���ڵ���������һ��,���� p=p.next
 * 2���ڶ���ָ�� pNext �� p һ��������� p.next==null ���ʾ pNext.next ��Ҫɾ���ڵ�
 *
 * ���������ɾ����һ���ڵ�
 */