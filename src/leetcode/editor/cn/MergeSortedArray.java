//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针
  
package leetcode.editor.cn;
public class MergeSortedArray{
      public static void main(String[] args) {
           Solution solution = new MergeSortedArray().new Solution();
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        int ptr = 0;
        int i = 0, j = 0;
        for (int k = 0; k < m; k++) temp[k] = nums1[k];
        while (i < m && j < n) {
            if (temp[i] < nums2[j]) nums1[ptr] = temp[i++];
            else nums1[ptr] = nums2[j++];
            ptr++;
        }
        if (i < m) {
            for (int k = i; k < m; k++, ptr++) nums1[ptr] = temp[k];
        }
        if (j < n) {
            for (int k = j; k < n; k++, ptr++) nums1[ptr] = nums2[k];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}