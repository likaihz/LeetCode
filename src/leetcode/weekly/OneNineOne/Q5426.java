package leetcode.weekly.OneNineOne;

import java.util.*;

/**
 * @author Li Kai
 */
public class Q5426 {
    public static void main(String[] args) {
        Solution solution = new Q5426().new Solution();
        System.out.println(solution.minReorder(6, new int[][]{{0,1}, {1, 3}, {2,3},{4, 0}, {4,5}}));
    }
    class Solution {
        public int minReorder(int n, int[][] connections) {
            HashMap<Integer, Set<Integer>> s2e = new HashMap<>();
            HashMap<Integer, Set<Integer>> e2s = new HashMap<>();
            for (int[] path : connections) {
                if (!s2e.containsKey(path[0])) {
                    s2e.put(path[0], new HashSet<>());
                }
                s2e.get(path[0]).add(path[1]);

                if (!e2s.containsKey(path[1])) {
                    e2s.put(path[1], new HashSet<>());
                }
                e2s.get(path[1]).add(path[0]);
            }
            int cnt = 0;

            LinkedList<Integer> q = new LinkedList<>();
            boolean[] vis = new boolean[connections.length];
            Arrays.fill(vis, false);
            q.addLast(0);

            while (!q.isEmpty()) {
                int crt = q.pop();
                Set<Integer> end = s2e.get(crt);
                if( end != null) {
                    for (int i : end) {
                        cnt++;
                        q.addLast(i);
                        if (e2s.containsKey(i)) {
                            e2s.get(i).remove(crt);
                        }
                    }
                }
                s2e.remove(crt);

                Set<Integer> start = e2s.get(crt);
                if (start != null) {
                    for (int i : start) {
                        q.addLast(i);
                        if (s2e.containsKey(i)) {
                            s2e.get(i).remove(crt);
                        }
                    }
                }
                e2s.remove(crt);
            }
            return cnt;
        }
    }
}
