//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi{
      public static void main(String[] args) {
           Solution solution = new CombinationSumIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          List<List<Integer>> res;
          int[] candidates;
          int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);

        dfs(0, 0, new ArrayList<>());

        return res;
    }

          private void dfs(int ptr, int sum, List<Integer> list) {
            if(sum == this.target) {
                this.res.add(new ArrayList<>(list));
                return;
            }
              if (ptr == candidates.length || sum > target) {
                  return;
              }

              for (int i = ptr; i < candidates.length; i++) {
                  if(i > ptr && candidates[i] == candidates[i-1]) continue;
                  list.add(candidates[i]);
                  dfs(i + 1, sum + candidates[i], list);
                  list.remove(list.size() - 1);
              }
          }
}
//leetcode submit region end(Prohibit modification and deletion)

}