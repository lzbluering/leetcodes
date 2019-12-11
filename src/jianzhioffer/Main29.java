package jianzhioffer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * �������к�Ϊĳһֵ��·��
 *
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * (ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 */
public class Main29 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        TreeNode right = new TreeNode(9);
        root.right = right;

        right.left = new TreeNode(3);
        right.left.right = new TreeNode(5);
        right.right = new TreeNode(3);

        FindPath(root, 22);
        for(ArrayList<Integer> list : lists){
            System.out.println(list.toString());
        }
    }

    private static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        lists.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return lists;
    }

    private static void backtracking(TreeNode root, int target, ArrayList<Integer> list){
        if(root == null)
            return;
        target -= root.val;
        list.add(root.val);
        if(target == 0 && root.left == null && root.right == null){
            lists.add(new ArrayList<>(list));
        }else{
            backtracking(root.left, target, list);
            backtracking(root.right, target, list);
        }
        list.remove(list.size()-1);
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
/**
 * ����˼·��
 * ���ݷ�
 */