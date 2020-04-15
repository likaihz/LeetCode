//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 1： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
//

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class JiQiRenDeYunDongFanWeiLcof{
      public static void main(String[] args) {
           Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
          System.out.println(solution.movingCount(3,1,0));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] bias = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] vis = new boolean[m][n];
        int cnt = 0;
        Queue<Coordinate> q = new LinkedList<>();
        for(boolean[] row: vis) Arrays.fill(row, false);

        vis[0][0] = true;
        q.add(new Coordinate(0, 0));
        Coordinate crt;
        while (!q.isEmpty()) {
            crt = q.poll();
            if (calSum(crt.x) + calSum(crt.y) <= k) {
                ++cnt;
                for (int i = 0; i < 4; i++) {
                    int x = crt.x + bias[i][0];
                    int y = crt.y + bias[i][1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (!vis[x][y]) {
                            vis[x][y] = true;
                            q.add(new Coordinate(x, y));
                        }
                    }
                }
            }
        }
        return cnt;
    }

    private int calSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}