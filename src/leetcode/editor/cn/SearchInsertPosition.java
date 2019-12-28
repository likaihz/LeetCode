//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找
  
package leetcode.editor.cn;
public class SearchInsertPosition{
      public static void main(String[] args) {
           Solution solution = new SearchInsertPosition().new Solution();
          System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 2));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid = (nums.length-1)/2;

        while(start <= end) {
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) end = mid-1;
            else start = mid+1;
            // 防止溢出
            mid = start+(end-start)/2;
        }
        return start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}