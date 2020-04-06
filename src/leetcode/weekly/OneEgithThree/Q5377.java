package leetcode.weekly.OneEgithThree;

/**
 * @author Li Kai
 */
public class Q5377 {
    public static void main(String[] args) {
        Solution solution = new Q5377().new Solution();
        System.out.println(solution.numSteps("1"));
    }


    class Solution {
        public int numSteps(String s) {
            StringBuilder sb = new StringBuilder(s);
            int res = 0;

            while (!(sb.length() == 1 && sb.charAt(0) == '1')) {
                if (sb.charAt(sb.length() - 1) == '0') {
                    // 如果是偶数
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb = add(sb);
                }
                res++;
            }

            return res;
        }

        private StringBuilder add(StringBuilder sb) {
            StringBuilder res = new StringBuilder();
            sb.insert(0, '0');

            // 加数指针
            int p = sb.length() - 1;
            // 进位
            int co = 1;
            while (co == 1) {
                if(sb.charAt(p) == '1') {
                    res.append('0');
                } else {
                    res.append('1');
                    co = 0;
                }
                p--;
            }
            res.reverse();

            if(p >= 0) res.insert(0, sb.subSequence(0, p + 1));
            if(res.charAt(0) == '0') res.deleteCharAt(0);
            return res;
        }
    }
}
