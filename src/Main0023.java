/**
 * 合并K个排序链表
 *
 * 合并?k?个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 * ? 1->4->5,
 * ? 1->3->4,
 * ? 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
 * 解题思路：
 * 一、分治法（分而治之）
 * k 个链表可以看作两组 k/2 链表合并
 * 最后变成 2 个链表合并后与其他的链表的合并链表继续合并
 */