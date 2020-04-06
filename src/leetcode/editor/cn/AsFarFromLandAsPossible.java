//你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，
//你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。 
//
// 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x
//1| + |y0 - y1| 。 
//
// 如果我们的地图上只有陆地或者海洋，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[1,0,1],[0,0,0],[1,0,1]]
//输出：2
//解释： 
//海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
// 
//
// 示例 2： 
//
// 
//
// 输入：[[1,0,0],[0,0,0],[0,0,0]]
//输出：4
//解释： 
//海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[i][j] 不是 0 就是 1 
// 
// Related Topics 广度优先搜索 图

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible{
      public static void main(String[] args) {
           Solution solution = new AsFarFromLandAsPossible().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          int[][] grid;
          int[][] bias = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int maxDistance(int[][] grid) {
        this.grid = grid;
        int max = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, minInstance(i, j));
                }
            }
        }
        return max;
    }

      private int minInstance(int x, int y) {
          boolean[][] vis = new boolean[grid.length][grid[0].length];
          for(boolean[] it: vis) Arrays.fill(it, false);
          Queue<Wrapper> q = new LinkedList<>();
          q.add(new Wrapper(x, y, 0));
          vis[x][y] = true;
          while (!q.isEmpty()) {
              Wrapper crt = q.poll();
              int cx = crt.x, cy = crt.y;
              if(grid[cx][cy] == 1) {
                  return crt.level;
              }
              for (int[] row : bias) {
                  if (cx + row[0] >= 0 && cx + row[0] < grid.length && cy + row[1] >= 0 && cy + row[1] < grid[0].length) {
                      if(!vis[cx+row[0]][cy+row[1]]) {
                          vis[cx+row[0]][cy+row[1]] = true;
                          q.add(new Wrapper(cx+row[0], cy+row[1], crt.level+1));
                      }
                  }
              }
          }
          return -1;
      }

    class Wrapper {
        int x, y, level;
        public Wrapper(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}