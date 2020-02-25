//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划

  
package leetcode.editor.cn;
public class PerfectSquares{
      public static void main(String[] args) {
           Solution solution = new PerfectSquares().new Solution();
           solution.numSquares(12);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        int sqrt;
        int min;
        int tmp;
        for (int i = 1; i <= n; i++) {
            sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                dp[i] = 1;
            } else {
                tmp = 1;
                min = dp[i - 1];
                while (i - tmp * tmp > 0) {
                    min = Math.min(min, dp[i-tmp*tmp]);
                    tmp++;
                }
                dp[i] = min+1;

            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}