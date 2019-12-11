package jianzhioffer;

import java.util.ArrayList;

/**
 * ������������˫������
 *
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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
 * ����˼·��
 * ��������洢���������Ľڵ㣬Ȼ��������
 */