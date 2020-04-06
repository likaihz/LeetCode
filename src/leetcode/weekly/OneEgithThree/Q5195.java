package leetcode.weekly.OneEgithThree;

/**
 * @author Li Kai
 */
public class Q5195 {

    public static void main(String[] args) {
        Solution solution = new Q5195().new Solution();
        long start = System.currentTimeMillis();
        System.out.println(solution.longestDiverseString(4,42,7));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            int[] cnt = new int[]{a, b, c};
            StringBuilder sb = new StringBuilder();
            int append = -1;
            int ban = -1;
            while (true) {
                ban = -1;
                append = -1;
                if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length()-2)) {
                    ban = (sb.charAt(sb.length() - 1) - 'a');
                }
                for (int i = 0; i < 3; i++) {
                    if(ban != i && (append==-1 || cnt[append] < cnt[i])) {
                        append = i;
                    }
                }
                if(append < 0 || cnt[append] <=0) break;
                sb.append((char)( 'a' + append));
                cnt[append]--;
            }

            return sb.toString();
        }
    }
}
