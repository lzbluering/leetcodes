package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * �Ѷ�������ӡ�ɶ���
 *
 * ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
 */
public class Main25 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> temp = new LinkedList<>();
        if(pRoot == null)
            return lists;
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode root = queue.poll();
                if(root.left != null)
                    temp.offer(root.left);
                if(root.right != null)
                    temp.offer(root.right);
                list.add(root.val);
            }
            while(!temp.isEmpty()){
                queue.offer(temp.poll());
            }
            lists.add(list);
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