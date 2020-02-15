//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划

  
package leetcode.editor.cn;

import java.util.List;

public class Triangle{
      public static void main(String[] args) {
           Solution solution = new Triangle().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if(m == 0) return 0;
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];

        dp[0][0] = triangle.get(0).get(0);
        if(m == 1) return dp[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        int min = dp[m - 1][0];
        for (int i = 1; i < m; i++) {
            if(dp[m-1][i] < min) min = dp[m - 1][i];
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}