//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划

  
package leetcode.editor.cn;
public class MaximalSquare{
      public static void main(String[] args) {
           Solution solution = new MaximalSquare().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        if(matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
            else dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == '1') {
                max = 1;
                dp[0][i] = 1;
            }
            else dp[0][i] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (matrix[i - 1][j - 1] > 0) {
                        int tmp1 = 0;
                        for (int k = i - 1; k >= 0; k--) {
                            if (matrix[k][j] == '1') {
                                tmp1 ++;
                            } else break;
                        }
                        int tmp2 = 0;
                        for (int k = j - 1; k >= 0; k--) {
                            if (matrix[i][k] == '1') {
                                tmp2++;
                            } else break;
                        }
                        dp[i][j] = Math.min(Math.min(tmp1, tmp2), dp[i - 1][j - 1]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max*max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}