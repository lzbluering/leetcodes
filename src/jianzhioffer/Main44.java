package jianzhioffer;

/**
 * leetcodes
 * ƽ�������
 * @author lzz
 * @date 2019/12/16
 *
 * ����һ�ö��������жϸö������Ƿ���ƽ���������
 */
public class Main44 {

    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }
    private int height(TreeNode root) {
        if(root == null || !isBalanced){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1){
            isBalanced = false;
        }

        return 1 + Math.max(left, right);
    }


}
