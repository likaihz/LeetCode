//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组

  
package leetcode.editor.cn;
public class NextPermutation{
      public static void main(String[] args) {
           Solution solution = new NextPermutation().new Solution();
          int[] nums = new int[]{1, 3, 2};
          solution.nextPermutation(nums);
          System.out.println(nums);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        // 先找到n[p] > n[p-1]
        int p = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i-1]) {
                p = i;
                break;
            }
        }
        if (p > 0) {
            int j = 0;
            // 将索引为p-1的元素与其右边的元素中比其大的最小元素交换
            for (int i = nums.length - 1; i >= p; i--) {
                if (nums[i] > nums[p-1]) {
                    j = i;
                    break;
                }
            }
            int tmp = nums[p - 1];
            nums[p - 1] = nums[j];
            nums[j] = tmp;
        }
        // 将p-1右边的元素反转
        int left = p, right = nums.length-1;
        int tmp;
        while (left < right) {
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}