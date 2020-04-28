//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法

  
package leetcode.editor.cn;

import java.util.*;

public class SubsetsIi{
      public static void main(String[] args) {
           Solution solution = new SubsetsIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        dfs(set, nums, new LinkedList<>(), 0);
        return new ArrayList<>(set);
    }

    private void dfs(Set<List<Integer>> set, int[] nums, LinkedList<Integer> now, int ptr) {
        if (ptr == nums.length) {
            set.add(new ArrayList<>(now));
            return;
        }
        dfs(set, nums, now, ptr + 1);
        now.add(nums[ptr]);
        dfs(set, nums, now, ptr + 1);
        now.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}