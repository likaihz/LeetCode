//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets{
      public static void main(String[] args) {
           Solution solution = new Subsets().new Solution();
          int[] nums = new int[]{1, 2, 3};
          System.out.println(solution.subsets(nums));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          List<List<Integer>> res;
          int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        this.nums = nums;
        dfs(0, new ArrayList<>());
        return res;
    }

          void dfs(int ptr, List<Integer> crt) {
              if (ptr == nums.length) {
                  res.add(new ArrayList<>(crt));
                  return;
              }
              dfs(ptr + 1, crt);
              crt.add(nums[ptr]);
              dfs(ptr + 1, crt);
              crt.remove(crt.size() - 1);
          }
}
//leetcode submit region end(Prohibit modification and deletion)

}