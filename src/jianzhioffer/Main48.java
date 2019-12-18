package jianzhioffer;

/**
 * �������ľ���
 *
 * ��Ŀ����
 * ���������Ķ�����������任ΪԴ�������ľ���
 * ��������:
 * �������ľ����壺Դ������
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	���������
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class Main48 {

    public void Mirror(TreeNode root) {
        mirrorTree(root);
    }

    private TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = mirrorTree(right);
        root.right = mirrorTree(left);

        return root;
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