//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划

  
package leetcode.editor.cn;

import java.util.Arrays;

public class LongestIncreasingSubsequence{
      public static void main(String[] args) {
           Solution solution = new LongestIncreasingSubsequence().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        int tmp = 1;
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            tmp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    tmp = Math.max(tmp, dp[j]);
                }
            }
            dp[i] = tmp+1;
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}