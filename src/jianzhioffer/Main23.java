package jianzhioffer;

/**
 * 对称的二叉树
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
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