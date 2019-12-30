package leetcode.weekly.OneSixNine;

/**
 * @author Li Kai
 */
public class SumZero {
    public static void main(String[] args) {
        Solution solution = new SumZero().new Solution();
        int[] res = solution.sumZero(1);
        for(int i: res) {
            System.out.println(i);
        }
    }

    class Solution {
        public int[] sumZero(int n) {
            int[] res = new int[n];
            if(n%2 != 0) res[n-1] = 0;
            for(int i = 0; i < n/2; i ++) {
                res[i] = i+1;
                res[i+n/2] = -(i+1);
            }
            return res;
        }
    }
}
