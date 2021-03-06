//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class CoinChange{
      public static void main(String[] args) {
           Solution solution = new CoinChange().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i : coins) {
            if(i <= amount) {
                dp[i] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            if (dp[i] < 0) {
                int min = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if(coin < i && dp[i-coin] > 0) {
                        min = Math.min(min, dp[i-coin]);
                    }
                }
                if(min < Integer.MAX_VALUE) {
                    dp[i] = min+1;
                }
                else dp[i] = -1;
            }
        }

        return dp[amount];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}