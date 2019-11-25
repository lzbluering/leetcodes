package jianzhioffer;

/**
 * leetcodes
 * ���л�������
 * @author lzz
 * @date 2019/11/25
 *
 * ��Ŀ����
 * ��ʵ�������������ֱ��������л��ͷ����л�������
 *
 * �����������л���ָ����һ�ö���������ĳ�ֱ�����ʽ�Ľ����ĳ�ָ�ʽ����Ϊ�ַ������Ӷ�ʹ���ڴ��н��������Ķ��������Գ־ñ��档
 * ���л����Ի����������򡢺��򡢲���Ķ�����������ʽ�������޸ģ����л��Ľ����һ���ַ��������л�ʱͨ�� ĳ�ַ��ű�ʾ�սڵ㣨#������ �� ��ʾһ�����ֵ�Ľ�����value!����
 *
 * �������ķ����л���ָ������ĳ�ֱ���˳��õ������л��ַ������str���ع���������
 */
public class Main07 {
    public String Serialize(TreeNode root) {

        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Serialize(root, sb);
        return sb.toString();
    }

    private void Serialize(TreeNode root, StringBuilder sb) {

        if(root == null){
            sb.append("#��");
            return;
        }

        sb.append(root.val);
        sb.append('��');
        Serialize(root.left, sb);
        Serialize(root.right, sb);
    }

    public TreeNode Deserialize(String str) {
        if(str.length() == 0){
            return null;
        }
        String[] strs = str.split("��");
        return Deserialize(strs);
    }

    private int index = -1;
    private TreeNode Deserialize(String[] strs) {
        index++;
        if(!"#".equals(strs[index])){
            TreeNode root = new TreeNode(Integer.parseInt(strs[index]));
            root.left = Deserialize(strs);
            root.right = Deserialize(strs);

            return root;
        }
        return null;
    }
}
/**
 * ����˼·��
 * 1�����л�ʱע�����;
 * 2�������л�ʱ����ʹ�õݹ飬�����ַ��������±� index Ҫע����ȫ�ֵı���;
 */