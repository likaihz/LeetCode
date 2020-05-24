package leetcode.weekly.OneNineZero;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Li Kai
 */
public class Q5417 {

    public static void main(String[] args) {
        Solution solution = new Q5417().new Solution();
        System.out.println(solution.maxVowels("tryhard", 4));
    }
    class Solution {
        public int maxVowels(String s, int k) {
            Set<Character> yuan = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
            int len = s.length();
            int[] dp = new int[len];
            Arrays.fill(dp, 0);

            int max = 0;
            for (int i = 0; i < k; i++) {
                if (yuan.contains(s.charAt(i))) {
                    max++;
                }
                dp[i] = max;
            }
            for (int i = k; i < len; i++) {
                if (yuan.contains(s.charAt(i))) {
                    if (!yuan.contains(s.charAt(i - k))) {
                        dp[i] = dp[i - 1] + 1;
                        max = Math.max(max, dp[i]);
                    } else {
                        dp[i] = dp[i - 1];
                    }
                } else {
                    if (!yuan.contains(s.charAt(i - k))) {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1] - 1;
                    }
                }
            }

            return max;
        }
    }
}
