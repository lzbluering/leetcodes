/**
 * �������������еĽڵ�
 *
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������
 *
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 *
 * ?
 *
 * ʾ��:
 *
 * ���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Main0024 {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        ListNode lList = head;
        ListNode rList = head.next;

        while(rList != null){
            lList.next = rList.next;
            rList.next = lList;
            temp.next = rList;

            temp = lList;
            lList = lList.next;
            rList = lList != null ? lList.next : null;
        }

        return ans.next;
    }

}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */