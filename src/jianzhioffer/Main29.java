package jianzhioffer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 二叉树中和为某一值的路径
 *
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
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
 * 解题思路：
 * 回溯法
 */