//给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations{
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          private int[] nums;
          private boolean[] visited;
          private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        this.nums = nums;
        visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        dfs(new ArrayList<>());
        return res;
    }

    private void dfs(List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}