package jianzhioffer;

/**
 * ����������һ���ڵ�
 *
 * ��Ŀ����
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 */
public class Main22 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.next;
            }
        }
        return null;
    }

}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
/**
 * public TreeLinkNode GetNext(TreeLinkNode pNode){
 *         if(pNode == null){
 *             return null;
 *         }else if(pNode.right != null){
 *             return rightNode(pNode.right);
 *         }else if(pNode.next != null){
 *             return parentNode(pNode, pNode.next);
 *         }
 *
 *         return null;
 *     }
 *
 *     private TreeLinkNode rightNode(TreeLinkNode root){
 *         if(root.left == null){
 *             return root;
 *         }
 *         return rightNode(root.left);
 *     }
 *
 *     private TreeLinkNode parentNode(TreeLinkNode pHead, TreeLinkNode root){
 *         if(root.left == pHead){
 *             return root;
 *         }
 *         if(root.next == null){
 *             return null;
 *         }
 *         return parentNode(root, root.next);
 *     }
 */