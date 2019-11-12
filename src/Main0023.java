/**
 * �ϲ�K����������
 *
 * �ϲ�?k?�������������غϲ������������������������㷨�ĸ��Ӷȡ�
 *
 * ʾ��:
 *
 * ����:
 * [
 * ? 1->4->5,
 * ? 1->3->4,
 * ? 2->6
 * ]
 * ���: 1->1->2->3->4->4->5->6
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-k-sorted-lists
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Main0023 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeK(lists, 0, lists.length - 1);
    }

    private ListNode mergeK(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }

        int mid = (start+end)/2;
        ListNode list1 = mergeK(lists, mid+1, end);
        ListNode list2 = mergeK(lists, start, mid);

        return nodeSort(list1, list2);
    }

    private ListNode nodeSort(ListNode l1, ListNode l2){
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return head.next;
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
/**
 * ����˼·��
 * һ�����η����ֶ���֮��
 * k ��������Կ������� k/2 ����ϲ�
 * ����� 2 ������ϲ���������������ĺϲ���������ϲ�
 */