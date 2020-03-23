//现在你总共有 n 门课需要选，记为 0 到 n-1。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1] 
//
// 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？ 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 说明: 
//
// 
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 
//
// 提示: 
//
// 
// 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。 
// 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 
// 
// 拓扑排序也可以通过 BFS 完成。 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CourseSchedule{
      public static void main(String[] args) {
           Solution solution = new CourseSchedule().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> courses = new HashSet<>(numCourses);

        Set<Integer> courNoPrev = new HashSet<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            courses.add(i);
        }

        boolean[] removed = new boolean[prerequisites.length];

        Set<Integer> tmp = new HashSet<>();
        Arrays.fill(removed, false);

        do {
            tmp.clear();

            for (int i = 0; i < prerequisites.length; i++) {
                if (!removed[i]) {
                    tmp.add(prerequisites[i][0]);
                }
            }

            courNoPrev = new HashSet<>(courses);
            courNoPrev.removeIf(tmp::contains);
            Iterator<Integer> it = courNoPrev.iterator();
            while (it.hasNext()) {
                int cur = it.next();
                for (int i = 0; i < prerequisites.length; i++) {
                    if (!removed[i]) {
                        if (cur == prerequisites[i][1]) {
                            removed[i] = true;
                        }
                    }
                }
                courses.remove(cur);
            }
        } while (!courNoPrev.isEmpty());

        return courses.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}