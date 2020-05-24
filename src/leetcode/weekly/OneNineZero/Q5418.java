package leetcode.weekly.OneNineZero;

import leetcode.editor.cn.TreeNode;

import java.util.Arrays;

/**
 * @author Li Kai
 */
public class Q5418 {
    public static void main(String[] args) {
        Solution solution = new Q5418().new Solution();
    }
    class Solution {
        int cnt = 0;
        int[] rec = new int[10];
        public int pseudoPalindromicPaths (TreeNode root) {
            if(root == null) return 1;
            cnt = 0;
            Arrays.fill(rec, 0);
            dfs(root);
            return cnt;
        }
        private void dfs(TreeNode node) {
            if (node.left == null && node.right == null) {
                rec[node.val] += 1;
                int odd = 0;
                for (int i = 1; i <= 9; i++) {
                    if (rec[i] % 2 == 1) {
                        odd++;
                    }
                }
                if(odd <= 1) {
                    cnt++;
                }
                rec[node.val] -= 1;
                return;
            }
            rec[node.val] += 1;
            if (node.left != null) {
                dfs(node.left);
            }
            if (node.right != null) {
                dfs(node.right);
            }
            rec[node.val] -= 1;

        }
    }
}
