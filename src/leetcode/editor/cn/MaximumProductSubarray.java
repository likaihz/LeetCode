//给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划

  
package leetcode.editor.cn;
public class MaximumProductSubarray{
      public static void main(String[] args) {
           Solution solution = new MaximumProductSubarray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length], dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dpMax[i] = Math.max(nums[i], nums[i] * dpMax[i - 1]);
                dpMin[i] = Math.min(nums[i], nums[i] * dpMin[i - 1]);
                if(max < dpMax[i]) max = dpMax[i];
            } else {
                dpMax[i] = Math.max(nums[i], nums[i] * dpMin[i - 1]);
                dpMin[i] = Math.min(nums[i], nums[i] * dpMax[i - 1]);
                if(max < dpMax[i]) max = dpMax[i];
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}