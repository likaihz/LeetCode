//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

  
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands{
      public static void main(String[] args) {
           Solution solution = new NumberOfIslands().new Solution();
           char[][] grid = new char[][] {
                   {'1','1','1','1','0'},
                   {'1','1','0','1','0'},
                   {'1','1','0','0','0'},
                   {'0','0','0','0','0'}};
          System.out.println(solution.numIslands(grid));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          Cor[][] father;
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        if(m*n ==0) return 0;
        father = new Cor[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                father[i][j] = new Cor(i, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0') {
                    if (i >= 1 && grid[i - 1][j] != '0') {
                        union(new Cor(i, j), new Cor(i-1, j));
                    }
                    if(j >= 1 && grid[i][j-1] != '0') {
                        union(new Cor(i, j), new Cor(i, j-1));
                    }
                }
            }
        }

        Set<Cor> res = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] != '0') {
                    res.add(findFather(new Cor(i, j)));
                }
            }
        }
        return res.size();
    }

    private Cor findFather(Cor cor) {
        if(father[cor.x][cor.y].equals(cor)) return cor;
        father[cor.x][cor.y] = findFather(father[cor.x][cor.y]);
        return father[cor.x][cor.y];
    }

    private void union(Cor p1, Cor p2) {
        Cor f1 = findFather(p1);
        Cor f2 = findFather(p2);
        if(!f1.equals(f2)) father[f1.x][f1.y] = f2;
    }
    class Cor {
        int x, y;

        public Cor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Cor)) {
                return false;
            }
            Cor cor = (Cor) obj;
            return this.x == cor.x && this.y == cor.y;
        }

        @Override
        public int hashCode() {
            return x+y;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}