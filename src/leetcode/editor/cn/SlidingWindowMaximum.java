//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
// Related Topics 堆 Sliding Window

  
package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum{
      public static void main(String[] args) {
           Solution solution = new SlidingWindowMaximum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 1) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        int left = 1, right = k;
        for (int i = 0; i < k; i++) queue.add(nums[i]);

        res[0] = queue.peek();
        while (right < nums.length) {
            if (res[left - 1] == nums[left - 1]) {
                queue.clear();
                for (int i = left; i <= right; i++) {
                    queue.add(nums[i]);
                }
            } else {
                queue.add(nums[right]);
            }
            res[left] = queue.peek();
            left++;
            right++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}