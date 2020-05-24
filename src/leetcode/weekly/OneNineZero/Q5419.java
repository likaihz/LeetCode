package leetcode.weekly.OneNineZero;

import java.util.Arrays;

/**
 * @author Li Kai
 */
public class Q5419 {
    public static void main(String[] args) {
        Solution solution = new Q5419().new Solution();
        System.out.println(solution.maxDotProduct(new int[]{2,1,-2,5}, new int[]{3,0,-6}));
    }
    class Solution {
        public int maxDotProduct(int[] nums1, int[] nums2) {
            int n1 = nums1.length, n2 = nums2.length;
            int[][] dp = new int[n1][n2];

            for(int[] r: dp) Arrays.fill(r, Integer.MIN_VALUE);

            dp[0][0] = nums1[0] * nums2[0];
            for (int j = 1; j < n2; j++) {
                dp[0][j] = Math.max(dp[0][j - 1], nums1[0] * nums2[j]);
            }
            for (int i = 1; i < n1; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);
            }

            for (int i = 1; i < n1; i++) {
                for (int j = 1; j < n2; j++) {
                    int self = nums1[i] * nums2[j];
                    if (dp[i - 1][j - 1] > 0) {
                        self += dp[i - 1][j - 1];
                    }
                    dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]), self));
                }
            }

            return dp[n1-1][n2-1];
        }
    }
}
