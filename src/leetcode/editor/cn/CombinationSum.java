//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum{
      public static void main(String[] args) {
           Solution solution = new CombinationSum().new Solution();
          System.out.println(solution.combinationSum(new int[]{2,3,5}, 8));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          List<List<Integer>> res;
          int target;
          int[] cand;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        this.target = target;
        this.cand = candidates;
        dfs(0, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int now, List<Integer> list, int ptr) {
        if(now == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(ptr >= cand.length || now > target) return;
        dfs(now, list, ptr+1);
        list.add(cand[ptr]);
        dfs(now + cand[ptr], list, ptr);
        list.remove(list.size() - 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}