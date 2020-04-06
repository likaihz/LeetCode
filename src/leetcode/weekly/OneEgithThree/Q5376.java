package leetcode.weekly.OneEgithThree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Kai
 */
public class Q5376 {
    public static void main(String[] args) {
        Solution solution = new Q5376().new Solution();
        System.out.println(solution.minSubsequence(new int[]{6}));

    }


class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        if(nums.length < 1) return new LinkedList<>();
        int[] record = new int[101];
        Arrays.fill(record, 0);
        int sum = 0;
        for(int i: nums) {
            ++record[i];
            sum += i;
        }

        List<Integer> res = new LinkedList<>();
        int subSum = 0;

        while (subSum <= sum-subSum) {
            for (int i = 100; i > 0; i--) {
                if (record[i] > 0) {
                    res.add(i);
                    record[i]--;
                    subSum += i;
                    break;
                }
            }
        }



        return res;
    }
}
}
