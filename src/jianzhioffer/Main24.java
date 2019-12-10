package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 按之字形顺序打印二叉树
 *
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Main24 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(pRoot == null)
            return lists;

        int layer = 0;
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            ++layer;
            ArrayList<Integer> list = new ArrayList<>();

            while(!queue.isEmpty()){
                TreeNode root = queue.poll();
                if(layer%2==1){
                    if(root.left != null)
                        stack.push(root.left);
                    if(root.right != null)
                        stack.push(root.right);
                }else{
                    if(root.right != null)
                        stack.push(root.right);
                    if(root.left != null)
                        stack.push(root.left);
                }
                list.add(root.val);
            }
            lists.add(list);
            while (!stack.isEmpty()){
                queue.offer(stack.pop());
            }
        }

        return lists;
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
/**
 * 解题思路：
 * 1、借助队列、栈
 * 2、每层节点出队时，这些节点的孩子进栈
 *     在 0、2、4、6... 层从右向左读入栈，再出栈进入队列
 *     在 1、3、5、7... 层从左向右读入栈，再出栈进入队列
 * 重复 2 ，此时队列即为正确的之字形顺序
 */