//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "A
//BCCED"
//输出：true
// 
//
// 示例 2： 
//
// 输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 动态规划

  
package leetcode.editor.cn;

import java.util.Arrays;

public class JuZhenZhongDeLuJingLcof{
      public static void main(String[] args) {
           Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
          solution.exist(new char[][]{{'a'}}, "a");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          char[][] board;
          char[] chars;
          int[][] bias = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
          boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.chars = word.toCharArray();
        this.visited = new boolean[board.length][board[0].length];
        for(boolean[] row: visited) Arrays.fill(row, false);


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(find(i,j,0)) return true;
            }
        }
        return false;
    }

    private boolean find(int m, int n, int p) {
        if(p == chars.length-1 && board[m][n] == chars[p]) return true;
        if(board[m][n] != chars[p]) return false;

        visited[m][n] = true;
        for (int[] item : bias) {
            int newM = m + item[0];
            int newN = n + item[1];
            if (newM >= 0 && newM < board.length && newN >= 0 && newN < board[0].length && !visited[newM][newN]) {
                if (find(newM, newN, p + 1)) {
                    return true;
                }
            }
        }
        visited[m][n] = false;
        return false;


    }


}
//leetcode submit region end(Prohibit modification and deletion)

}