//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表

  
package leetcode.editor.cn;

import java.util.Arrays;

public class ShuZuZhongZhongFuDeShuZiLcof{
      public static void main(String[] args) {
           Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int findRepeatNumber(int[] nums) {
      int tmp;
      for (int i = 0; i < nums.length; i++) {
          while (nums[i] != i) {
              if(nums[nums[i]] == nums[i]) return nums[i];
              tmp = nums[nums[i]];
              nums[nums[i]] = nums[i];
              nums[i] = tmp;
          }
      }
      return 0;
  }
}
//leetcode submit region end(Prohibit modification and deletion)


    class Solution3 {
        public int findRepeatNumber(int[] nums) {
            int[] copy = new int[nums.length];

            Arrays.fill(copy, -1);

            for (int i = 0; i < nums.length; i++) {
                if (copy[nums[i]] >= 0) {
                    return nums[i];
                } else {
                    copy[nums[i]] = nums[i];
                }
            }
            return 0;
        }
    }
}