//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations{
      public static void main(String[] args) {
           Solution solution = new Combinations().new Solution();
          System.out.println(solution.combine(4,2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          List<List<Integer>> res;
          int N, K;
    public List<List<Integer>> combine(int n, int k) {
        N = n;
        K = k;
        res = new ArrayList<>();

        dfs(0, 1, new LinkedList<Integer>());
        return res;
    }

    void dfs(int crt, int ptr, List<Integer> nums) {
        if (crt == K) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = ptr; i <=  N-K+crt+1 ; i++) {
            nums.add(i);
            dfs(crt+1, i+1, nums);
            nums.remove(crt);
        }

//        if(ptr <= N) {
//            nums.add(ptr);
//            dfs(crt + 1, ptr + 1, nums);
//            nums.add(ptr);
//        }
//
//        if (N - ptr >= K - crt) {
//            dfs(crt, ptr+1, nums);
//        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}