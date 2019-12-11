package jianzhioffer;

import java.util.ArrayList;

/**
 * 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Main31 {

    private ArrayList<TreeNode> list = new ArrayList<>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        midSort(pRootOfTree);

        if(list.size() < 1)
            return null;
        for(int i=0; i<list.size(); ++i){
            list.get(i).right = (i+1 < list.size()) ? list.get(i+1) : null;
            list.get(i).left = (i-1 >= 0) ? list.get(i-1) : null;
        }
        return list.get(0);
    }

    private void midSort(TreeNode root){
        if(root == null)
            return;
        midSort(root.left);
        list.add(root);
        midSort(root.right);
    }

}
/**
 * 解题思路：
 * 借助链表存储中序遍历厚的节点，然后串联起来
 */