//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true.
//给定 word = "SEE", 返回 true.
//给定 word = "ABCB", 返回 false. 
// Related Topics 数组 回溯算法

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch{
      public static void main(String[] args) {
           Solution solution = new WordSearch().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          char[][] board;
          boolean[][] visited;
          char[] chars;
          boolean res;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
        chars = word.toCharArray();
        res = false;


        List<Integer> ms = new ArrayList<>();
        List<Integer> ns = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    ms.add(i);
                    ns.add(j);
                }
            }
        }
        for (int i = 0; i < ms.size(); i++) {
            dfs(ms.get(i), ns.get(i), 0);
        }
        return res;
    }

    private void dfs(int m, int n, int ptr) {
        if(ptr == chars.length) {
            res = true;
            return;
        }
        if(m >= board.length || n >= board[0].length || m < 0 || n < 0) return;
        if(visited[m][n]) return;
        if(board[m][n] != chars[ptr]) return;

        visited[m][n] = true;
        dfs(m-1, n, ptr+1);
        if(!res) dfs(m+1, n, ptr+1);
        if(!res) dfs(m, n - 1, ptr + 1);
        if(!res) dfs(m, n+1, ptr+1);
        visited[m][n] = false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}