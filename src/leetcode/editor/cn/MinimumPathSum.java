//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

  
package leetcode.editor.cn;

import java.util.Arrays;

public class MinimumPathSum{
      public static void main(String[] args) {
           Solution solution = new MinimumPathSum().new Solution();
           int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
          solution.minPathSum(grid);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] record = new int[m][n];
        record[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            record[i][0] = record[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            record[0][i] = record[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                record[i][j] = Math.min(record[i - 1][j], record[i][j - 1]) + grid[i][j];
            }
        }
        return record[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}