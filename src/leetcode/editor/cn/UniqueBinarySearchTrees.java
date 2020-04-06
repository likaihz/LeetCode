//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划

  
package leetcode.editor.cn;

import java.util.Arrays;

public class UniqueBinarySearchTrees{
      public static void main(String[] args) {
           Solution solution = new UniqueBinarySearchTrees().new Solution();
          System.out.println(solution.numTrees(3));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        if(n == 0 || n == 1) return 1;
        int[] nums = new int[n+1];
        Arrays.fill(nums, 0);
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            int res = 0;
            for (int j = 0; j < i; j++) {
                res += nums[j] * nums[i - j - 1];
            }
            nums[i] = res;
        }
        return nums[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}