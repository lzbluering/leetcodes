package jianzhioffer;

/**
 * �����˵��˶���Χ
 *
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 */
public class Main02 {

    public static void main(String[] args) {

        System.out.println(movingCount(10, 1, 100));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        if(threshold == 0 || rows == 0 || cols == 0){
            return 0;
        }
        int[][] nums = new int[rows][cols];
        moving(threshold, 0, 0, nums);

        int result = 0;
        for(int i=0; i<nums.length; ++i){
            for(int j=0; j<nums[0].length; ++j){
                if(nums[i][j] == 1){
                    ++result;
                }
            }
        }

        return result;
    }

    private static void moving(int threshold, int i, int j, int[][] nums) {
        if((i<0 || i>=nums.length) || (j<0 || j>=nums[0].length) || nums[i][j] != 0 ){
            return;
        }
        String str = i+""+j;
        int sum = 0;
        for(int k = 0; k<str.length(); ++k){
            sum += Integer.parseInt(str.substring(k, k+1));
        }
        if(sum<=threshold){
            nums[i][j] = 1;
        }else{
            nums[i][j] = 2;
        }

        moving(threshold, i+1, j, nums);
        moving(threshold, i-1, j, nums);
        moving(threshold, i, j+1, nums);
        moving(threshold, i, j-1, nums);
    }

}
