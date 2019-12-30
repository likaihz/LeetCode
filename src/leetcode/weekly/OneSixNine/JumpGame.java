package leetcode.weekly.OneSixNine;

/**
 * @author Li Kai
 */
public class JumpGame {

    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();

    }
    class Solution {
        public boolean canReach(int[] arr, int start) {
            boolean[] visited = new boolean[arr.length];
            for(int i = 0 ; i < arr.length; i++) visited[i] = false;
            return help(arr, start, visited);
        }
        private boolean help(int[] arr, int start, boolean[] visited) {
            if(start<0 || start >= arr.length) return false;
            if(visited[start]) return false;
            visited[start] = true;
            if(arr[start] == 0) return true;
            return help(arr, start + arr[start], visited) || help(arr, start - arr[start], visited);

        }
    }
}
