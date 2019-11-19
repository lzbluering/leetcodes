package jianzhioffer;

/**
 * �����˵��˶���Χ
 *
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 *
 * ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 */
public class Main02 {

    public static void main(String[] args) {

        System.out.println(movingCount(10, 1, 100));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] vis = new boolean[rows][cols];
        return move(threshold, rows, cols, 0, 0, vis);
    }

    public static int move(int threshold, int rows, int cols, int x, int y, boolean[][] vis) {

        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};

        vis[x][y] = true;
        int ans = 1;
        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if (X >= 0 && Y >= 0 && X < rows && Y < cols && !vis[X][Y] && sum(X) + sum(Y) <= threshold) {
                ans += move(threshold, rows, cols, X, Y, vis);
            }
        }
        return ans;
    }

    public static int sum(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }

}
/**
 * ����˼·��
 * ��ȱ����������������飬�������Ľڵ�Ϊ�棬�������нڵ�
 */