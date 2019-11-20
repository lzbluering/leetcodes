package jianzhioffer;

import java.util.LinkedList;

/**
 * leetcodes
 * �����������ĵ�K���ڵ�
 * @author lzz
 * @date 2019/11/20
 *
 * ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣���磬 ��5��3��7��2��4��6��8��    �У��������ֵ��С˳�����С����ֵΪ4��
 */
public class Main06 {

    LinkedList<TreeNode> list = new LinkedList<>();
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k==0){
            return null;
        }

        getMidSort(pRoot);

        return k<=list.size() ? list.get(k-1) : null;
    }

    private void getMidSort(TreeNode pRoot) {

        if(pRoot.left != null){
            getMidSort(pRoot.left);
        }
        list.add(pRoot);
        if(pRoot.right != null){
            getMidSort(pRoot.right);
        }
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
/**
 * ����˼·������������ҳ���K���ڵ�
 * ���������k == 0��pRoot == null��k == pRoot.size()
 */