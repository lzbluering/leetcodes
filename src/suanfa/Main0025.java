package suanfa;

/**
 * K ��һ�鷭ת����
 *
 * ����һ������ÿ?k?���ڵ�һ����з�ת�����㷵�ط�ת�������
 *
 * k?��һ��������������ֵС�ڻ��������ĳ��ȡ�
 *
 * ����ڵ���������?k?������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 *
 * ʾ�� :
 *
 * �����������1->2->3->4->5
 *
 * ��?k?= 2 ʱ��Ӧ������: 2->1->4->3->5
 *
 * ��?k?= 3 ʱ��Ӧ������: 3->2->1->4->5
 *
 * ˵�� :
 *
 * ����㷨ֻ��ʹ�ó����Ķ���ռ䡣
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Main0025 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            if (end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}
/**
 * Definition for singly-linked list.
 * public class suanfa.ListNode {
 *     int val;
 *     suanfa.ListNode next;
 *     suanfa.ListNode(int x) { val = x; }
 * }
 */
/**
 * ����˼·��
 * δ���
 */