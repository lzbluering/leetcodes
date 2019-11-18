package jianzhioffer;

/**
 * 机器人的运动范围
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
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
