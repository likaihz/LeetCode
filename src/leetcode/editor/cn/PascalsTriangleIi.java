//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组
  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi{
      public static void main(String[] args) {
           Solution solution = new PascalsTriangleIi().new Solution();
          System.out.println(solution.getRow(4));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(rowIndex == 0)
            return res;
        if(rowIndex == 1) {
            res.add(1);
            return res;
        }
        List<Integer> tmp;
        for (int i = 2; i <= rowIndex+1; i++) {
            // 构造出第i行，并赋值给res
            tmp = res;
            res = new ArrayList<>();
            res.add(1);
            for (int j = 1; j < i-1; j++) {
                res.add(tmp.get(j - 1) + tmp.get(j));
            }
            res.add(1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}