package suanfa;

/**
 * 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第?n?个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n?保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
 * 解题思路：
 * 1、双指针，第一个指针 p 先遍历 n，此时如果 p.next==null 则表示删除节点在正数第一个,否则 p=p.next
 * 2、第二个指针 pNext 与 p 一起遍历，当 p.next==null 则表示 pNext.next 是要删除节点
 *
 * 极端情况：删除第一个节点
 */