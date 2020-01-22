//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest{
      public static void main(String[] args) {
           Solution solution = new ThreeSumClosest().new Solution();
          int[] nums = new int[]{1, 1, 1, 1};
          System.out.println(solution.threeSumClosest(nums, 0));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int dif = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int i = 0, left, right;
        while (i < nums.length - 2) {
            left = i+1;
            right = nums.length - 1;
            while (left < right) {
                if (Math.abs(nums[i] + nums[left] + nums[right]-target) < dif) {
                    res = nums[i] + nums[left] + nums[right];
                    dif = Math.abs(nums[i] + nums[left] + nums[right]-target);
                    // 左右指针都要找到下一个位置
                    if(res >= target) right--;
                    if(res <= target) left++;
                } else if (nums[i] + nums[left] + nums[right] < target) {
                    // 左指针要找到下一个位置
                    left++;
                } else {
                    // 右指针要找到下一个位置
                    right--;
                }
            }
            i++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}