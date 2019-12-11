package jianzhioffer;

/**
 * 二叉搜索树的后序遍历序列
 *
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Main28 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null)
            return true;
        if(sequence.length == 0)
            return false;

        return isSearchTree(sequence, 0, sequence.length-1);
    }

    public boolean isSearchTree(int [] sequence, int start, int end) {
        if(start >= end)
            return true;

        int i = start;
        while(i<end){
            if(sequence[i] < sequence[end])
                ++i;
            else
                break;
        }
        int index = i;
        while(i<end){
            if(sequence[i] > sequence[end])
                ++i;
            else
                break;
        }
        return (i == end ? true : false) & isSearchTree(sequence, start, i-1) & isSearchTree(sequence, i, end-1);
    }
}
/**
 * 解题分析：
 * 1、二叉搜索树特性：根节点左边的节点都比根节点小，根节点右边的节点都比根节点大
 * 2、数组为空代表空树的后序遍历
 * 3、数组长度为零不存在对应的二叉搜索树
 * 4、后序遍历是：左右根
 */