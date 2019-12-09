package jianzhioffer;

/**
 * 删除链表中重复的节点
 *
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Main21 {

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode root = pHead.next;
        if(pHead.val == root.val){
            while(root != null && root.val == pHead.val){
                root = root.next;
            }
            return deleteDuplication(root);
        }else{
            pHead.next =  deleteDuplication(root);
            return pHead;
        }
    }

}
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
/**
 * 解题思路：
 * 1、运用递归
 *     如果链表为空或者只有一个节点，直接返回该链表的头节点
 *     如果两个节点相同、则遍历到不相同的节点，利用该节点当作头节点继续递归
 *     如果两个节点不同、第一个节点的 next 指向以第二个节点来递归的返回节点
 */