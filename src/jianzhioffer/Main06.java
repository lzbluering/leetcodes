package jianzhioffer;

import java.util.LinkedList;

/**
 * leetcodes
 * 二叉搜索树的第K个节点
 * @author lzz
 * @date 2019/11/20
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
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
 * 解题思路：中序遍历后找出第K个节点
 * 极端情况：k == 0、pRoot == null、k == pRoot.size()
 */