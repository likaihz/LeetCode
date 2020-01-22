//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三
//元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, left, right;
        if (nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return res;
        }
        while (i < nums.length - 2) {
            if(nums[i] > 0) break;
            left = i+1;
            right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 左右指针都要找到下一个位置
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                    do {
                        right --;
                    } while (left < right && nums[right] == nums[right+1]);
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    // 左指针要找到下一个位置
                    if(nums[right] < 0) break;
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                } else {
                    // 右指针要找到下一个位置
                    if(nums[i] > 0) break;
                    do {
                        right --;
                    } while (left < right && nums[right] == nums[right+1]);
                }
            }
            do {
                i++;
            } while (i < nums.length-2 && nums[i] == nums[i-1]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}