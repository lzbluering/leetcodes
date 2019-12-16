package jianzhioffer;

/**
 * leetcodes
 * ��������ĵ�һ���������
 * @author lzz
 * @date 2019/12/16
 *
 * �������������ҳ����ǵĵ�һ��������㡣
 */
public class Main41 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

}
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * ����˼·��
 * �� ��һ�������� a+c ���ڶ��������� b+c (a�����һ�������ཻ�ĳ��ȣ�b����ڶ��������ཻ�ĳ��ȣ�c�����ཻ�ĳ���)
 * �� a+c+b == b+c+a
 * �ⷨҲ���������������ཻ����� ==> �� c = 0 ʱ
 */