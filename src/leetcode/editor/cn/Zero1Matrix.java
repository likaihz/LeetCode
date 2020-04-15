//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

public class Zero1Matrix{
      public static void main(String[] args) {
           Solution solution = new Zero1Matrix().new Solution();

      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          int lenX;
          int lenY;

          public int[][] updateMatrix(int[][] matrix) {
              lenX = matrix.length;
              lenY = matrix[0].length;
              for (int i = 0; i < lenX; i++) {
                  for (int j = 0; j < lenY; j++) {
                      if (matrix[i][j] != 0) {
                          matrix[i][j] = findZero(matrix, i, j);
                      }
                  }
              }
              return matrix;
          }

          public int findZero(int[][] matrix, int x, int y) {
              int result = 0;
              int curX = x;
              int curY = y;
              while (true) {
                  result++;
                  int c = result;
                  int i = 0;
                  //p1 left
                  curX--;
                  for (i = 0; i < c; i++) {
                      curX++;
                      curY--;
                      if (curX >= 0 && curX < lenX && curY >= 0 && curY < lenY) {
                          if (matrix[curX][curY] == 0) {
                              return result;
                          }
                      }
                  }
                  for (i = 0; i < c; i++) {
                      curX++;
                      curY++;
                      if (curX >= 0 && curX < lenX && curY >= 0 && curY < lenY) {
                          if (matrix[curX][curY] == 0) {
                              return result;
                          }
                      }
                  }
                  for (i = 0; i < c; i++) {
                      curX--;
                      curY++;
                      if (curX >= 0 && curX < lenX && curY >= 0 && curY < lenY) {
                          if (matrix[curX][curY] == 0) {
                              return result;
                          }
                      }
                  }
                  for (i = 0; i < c; i++) {
                      curX--;
                      curY--;
                      if (curX >= 0 && curX < lenX && curY >= 0 && curY < lenY) {
                          if (matrix[curX][curY] == 0) {
                              return result;
                          }
                      }
                  }
              }
          }
      }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution3 {
        public int[][] updateMatrix(int[][] matrix) {
            if(matrix == null) return null;
            int n = matrix.length;
            if(n == 0) return new int[0][0];
            int m = matrix[0].length;
            if(m == 0) return new int[n][0];


            int[][] bias = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int[][] res = new int[n][m];
            boolean[][] vis = new boolean[n][m];
            LinkedList<Cor> q = new LinkedList<>();


            for(boolean[] l: vis) Arrays.fill(l, false);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        q.add(new Cor(i, j));
                        res[i][j] = 0;
                        vis[i][j] = true;
                    }
                }
            }

            while (!q.isEmpty()) {
                Cor cor = q.poll();
                for (int[] l : bias) {
                    int newX = cor.x + l[0];
                    int newY = cor.y + l[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && !vis[newX][newY]) {
                        vis[newX][newY] = true;
                        res[newX][newY] = res[cor.x][cor.y] + 1;
                        q.add(new Cor(newX, newY));
                    }
                }
            }

            return res;
        }

        class Cor {
            int x, y;
            public Cor(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object obj) {
                Cor o = (Cor) obj;
                return x == o.x && y == o.y;
            }
        }
    }
    class Solution2 {
        public int[][] updateMatrix(int[][] matrix) {
            if(matrix == null) return null;
            int n = matrix.length;
            if(n == 0) return new int[0][0];
            int m = matrix[0].length;
            if(m == 0) return new int[n][0];


            int[][] bias = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int[][] res = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(matrix[i][j] == 0) res[i][j] = 0;
                    else res[i][j] = -1;
                }
            }

            int thisTurn = 0;
            boolean found = true;
            while (found) {
                found = false;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (res[i][j] == thisTurn) {
                            for (int[] line : bias) {
                                int newI = i + line[0];
                                int newJ = j + line[1];
                                if (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                                    if(res[newI][newJ] < 0){
                                        found = true;
                                        res[newI][newJ] = thisTurn+1;
                                    }
                                }
                            }
                        }
                    }
                }
                ++thisTurn;
            }

            return res;
        }
    }


    class SolutionDP {
        public int[][] updateMatrix(int[][] matrix) {
            if(matrix == null) return null;
            int n = matrix.length;
            if(n == 0) return new int[0][0];
            int m = matrix[0].length;
            if(m == 0) return new int[n][0];

            int[][] res = new int[n][m];
            for(int[] l: res) Arrays.fill(l, Integer.MAX_VALUE);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        res[i][j] = 0;
                    } else {
                        int min = Integer.MAX_VALUE;
                        if(i-1 >= 0 && res[i-1][j] != Integer.MAX_VALUE) min = res[i - 1][j];
                        if(j -1 >= 0 && res[i][j-1] != Integer.MAX_VALUE) min = Math.min(min, res[i][j - 1]);
                        if(min != Integer.MAX_VALUE) res[i][j] = Math.min(min + 1, res[i][j]);
                    }
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (matrix[i][j] != 0) {
                        int min = Integer.MAX_VALUE;
                        if(i+1 < n && res[i+1][j] != Integer.MAX_VALUE) min = res[i + 1][j];
                        if(j+1 < m && res[i][j+1] != Integer.MAX_VALUE) min = Math.min(min, res[i][j + 1]);
                        if(min != Integer.MAX_VALUE) res[i][j] = Math.min(min + 1, res[i][j]);
                    }
                }
            }

            return res;
        }
    }
}