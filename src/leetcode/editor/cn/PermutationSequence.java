//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法

  
package leetcode.editor.cn;

import java.util.Arrays;

public class PermutationSequence{
      public static void main(String[] args) {
           Solution solution = new PermutationSequence().new Solution();
          System.out.println(solution.getPermutation(4,9));

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          int[] factOf = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
          boolean[] visited;
          int N;
    public String getPermutation(int n, int k) {
        N = n;
        visited = new boolean[n + 1];
        Arrays.fill(visited, false);

        StringBuilder sb = new StringBuilder();

        recursive(sb, n, k-1);

        return sb.toString();
    }

    void recursive(StringBuilder sb, int n, int k) {
        if(n == 0) return;
        int l = k / factOf[n-1] + 1;

        int r = k % factOf[n - 1];


        for (int i = 1, cnt = 1; i <= N; i++) {
            if (!visited[i]) {
                if (l == cnt) {
                    sb.append(i);
                    visited[i] = true;
                    break;
                } else {
                    cnt++;
                }
            }
        }

        recursive(sb, n-1, r);

    }



}
//leetcode submit region end(Prohibit modification and deletion)

}