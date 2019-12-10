package jianzhioffer;

/**
 * �ԳƵĶ�����
 *
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 */
public class Main23 {

    public boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null)
            return true;

        return isSame(pRoot.left, pRoot.right);
    }

    private boolean isSame(TreeNode lRoot, TreeNode rRoot) {

        if(lRoot != null && rRoot != null){
            if(lRoot.val != rRoot.val)
                return false;
            return isSame(lRoot.left, rRoot.right) & isSame(lRoot.right, rRoot.left);
        }else if(lRoot == null && rRoot == null){
            return true;
        }

        return false;
    }
}
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/