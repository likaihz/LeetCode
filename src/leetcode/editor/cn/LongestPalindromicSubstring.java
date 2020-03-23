//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

  
package leetcode.editor.cn;

import java.util.Arrays;

public class LongestPalindromicSubstring{
      public static void main(String[] args) {
           Solution solution = new LongestPalindromicSubstring().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int max = 1;
        int left = 1, right = 1;
        int len = s.length();
        int p1, p2;
        for (int i = 1; i < len; i++) {
            p1 = i-1;
            p2 = i+1;
            while (p1 >= 0 && p2 < len) {
                if (s.charAt(p1) == s.charAt(p2)) {
                    if (p2 - p1 + 1 > max) {
                        max = p2-p1+1;
                        left = p1;
                        right = p2;
                    }
                    p1--;
                    p2++;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < len; i++) {
            p1 = i-1;
            p2 = i;
            while (p1 >= 0 && p2 < len) {
                if (s.charAt(p1) == s.charAt(p2)) {
                    if (p2 - p1 + 1 > max) {
                        max = p2-p1+1;
                        left = p1;
                        right = p2;
                    }
                    p1--;
                    p2++;
                } else {
                    break;
                }
            }
        }

        return s.substring(left, right+1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)



    class Solution2 {
        String S;
        public String longestPalindrome(String s) {
            if(s == null || s.length() <=1) return s;
            S = s;
            int left = 0, right = 0;
            int longest = 1;
            int l = s.length();
            for (int i = 0; i < l; i++) {
                for (int j = i + longest; j < l; j++) {
                    if(isPal(i,j) && j-i+1 > longest) {
                        left = i;
                        right = j;
                        longest = j-i+1;
                    }
                }
            }
            return s.substring(left, right+1);
        }
        public boolean isPal(int head, int rear) {
            if(rear == head) return true;

            int l = rear-head+1;
            int left, right;
            if (l % 2 == 0) {
                left = head+l/2-1;
                right = head+l/2;
            } else {
                left = head+l/2-1;
                right = head+l/2+1;
            }

            while (left >= head) {
                if(S.charAt(left--) != S.charAt(right++)) return false;
            }
            return true;
        }
    }

    class Solution3 {
        public String longestPalindrome(String s) {
            if (s == null || s.length() <= 1) return s;
            int len = s.length();
            boolean[][] dp = new boolean[len][len];

            for(boolean[] it: dp) Arrays.fill(it, false);
            for(int i = 0; i < len; i++) dp[i][i] = true;

            int left = 0, right = 0;
            int max = 1;
            if(s.charAt(0) == s.charAt(1)){
                left = 0; right = 1;
                max = 2;
            }
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if ((i-j == 1 || dp[j+1][i-1]) && s.charAt(i) == s.charAt(j)) {
                        dp[j][i] = true;
                        if (max < i - j + 1) {
                            max = i-j+1;
                            left = j;
                            right = i;
                        }
                    }
                }
            }
            return s.substring(left, right+1);
        }

    }
}