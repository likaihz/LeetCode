//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals{
      public static void main(String[] args) {
           Solution solution = new MergeIntervals().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(right < intervals[i][0]){
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            } else if (right < intervals[i][1]) {
                right = intervals[i][1];
            }
        }
        res.add(new int[]{left, right});
        int[][] l = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            l[i][0] = res.get(i)[0];
            l[i][1] = res.get(i)[1];
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}