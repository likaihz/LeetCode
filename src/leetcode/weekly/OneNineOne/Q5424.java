package leetcode.weekly.OneNineOne;

/**
 * @author Li Kai
 */
public class Q5424 {

    class Solution {
        public int maxProduct(int[] nums) {
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length-1; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    res = Math.max(res, (nums[i] - 1) * (nums[j] - 1));
                }
            }

            return res;
        }
    }
}
