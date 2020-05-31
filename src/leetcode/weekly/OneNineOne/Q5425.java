package leetcode.weekly.OneNineOne;

import java.util.Arrays;

/**
 * @author Li Kai
 */
public class Q5425 {
    public static void main(String[] args) {
        Solution solution = new Q5425().new Solution();
        System.out.println(solution.maxArea(5, 4, new int[]{3,1}, new int[]{1}));
    }
    class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            int MOD = 1000000007;
            Arrays.sort(horizontalCuts);
            Arrays.sort(verticalCuts);

            long len1 = horizontalCuts[0];
            for (int i = 1; i < horizontalCuts.length; i++) {
                len1 = Math.max(len1, horizontalCuts[i] - horizontalCuts[i - 1]);
            }
            len1 = Math.max(len1, h - horizontalCuts[horizontalCuts.length - 1]);

            long len2 = verticalCuts[0];
            for (int i = 1; i < verticalCuts.length; i++) {
                len2 = Math.max(len2, verticalCuts[i] - verticalCuts[i - 1]);
            }

            len2 = Math.max(len2, w - verticalCuts[verticalCuts.length - 1]);

            int res = (int)((len1 * len2) % MOD);
            return res;
        }
    }
}
