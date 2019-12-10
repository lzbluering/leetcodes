package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ��֮����˳���ӡ������
 *
 * ��ʵ��һ����������֮���δ�ӡ��������
 * ����һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
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
 * ����˼·��
 * 1���������С�ջ
 * 2��ÿ��ڵ����ʱ����Щ�ڵ�ĺ��ӽ�ջ
 *     �� 0��2��4��6... ������������ջ���ٳ�ջ�������
 *     �� 1��3��5��7... ��������Ҷ���ջ���ٳ�ջ�������
 * �ظ� 2 ����ʱ���м�Ϊ��ȷ��֮����˳��
 */