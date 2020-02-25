//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 示例 1: 
//
// 输入: nums: [1, 1, 1, 1, 1], S: 3
//输出: 5
//解释: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 注意: 
//
// 
// 数组非空，且长度不会超过20。 
// 初始的数组的和不会超过1000。 
// 保证返回的最终结果能被32位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划

  
package leetcode.editor.cn;
public class TargetSum{
      public static void main(String[] args) {
           Solution solution = new TargetSum().new Solution();
          int[] nums = new int[]{1, 1, 1, 1, 1};
          System.out.println(solution.findTargetSumWays(nums, 3));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          int cnt;
          int target;
          int[] nums;
          public int findTargetSumWays(int[] nums, int S) {
             return 0;
          }
    public int findTargetSumWays_old(int[] nums, int S) {
        cnt=0;
        target = S;
        this.nums = nums;
        dfs(0, 0);
        return cnt;
    }
    private void dfs(int ptr, int sum) {
        if (ptr == nums.length) {
            if(sum == target) cnt++;
            return;
        }
        dfs(ptr+1, sum+nums[ptr]);
        dfs(ptr+1, sum - nums[ptr]);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}