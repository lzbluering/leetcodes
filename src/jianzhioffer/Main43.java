package jianzhioffer;

/**
 * leetcodes
 * �����������
 * @author lzz
 * @date 2019/12/16
 *
 * ����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 */
public class Main43 {

    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left != null || root.right != null){
            return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
        }

        return 1;
    }

}
/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */