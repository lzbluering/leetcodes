package jianzhioffer;

/**
 * leetcodes
 * 二叉树的深度
 * @author lzz
 * @date 2019/12/16
 *
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
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