//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组 
// 👍 772 👎 0

  
package leetcode.editor.cn;
public class FirstMissingPositive{
      public static void main(String[] args) {
           Solution solution = new FirstMissingPositive().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        int n = nums.length;


        for (int i = 0; i < n; i++) {
            // 要把值为[1, n]之间的数字x放到它该在的地方（即x-1处），但是换过去之前还要判断下目标位置上是不是已经是x了，如果是的话就说明有重复了，那就跳过
            while (nums[i] != i + 1 && nums[i] <= n && nums[i] > 0 && nums[nums[i]-1] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}