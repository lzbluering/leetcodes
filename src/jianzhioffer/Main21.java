package jianzhioffer;

/**
 * ɾ���������ظ��Ľڵ�
 *
 * ��Ŀ����
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 *
 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
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
 * ����˼·��
 * 1�����õݹ�
 *     �������Ϊ�ջ���ֻ��һ���ڵ㣬ֱ�ӷ��ظ������ͷ�ڵ�
 *     ��������ڵ���ͬ�������������ͬ�Ľڵ㣬���øýڵ㵱��ͷ�ڵ�����ݹ�
 *     ��������ڵ㲻ͬ����һ���ڵ�� next ָ���Եڶ����ڵ����ݹ�ķ��ؽڵ�
 */