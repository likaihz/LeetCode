package leetcode.weekly.OneNineZero;

/**
 * @author Li Kai
 */
public class Q5416 {
    public static void main(String[] args) {
        Solution solution = new Q5416().new Solution();
        System.out.println(solution.isPrefixOfWord("this problem is an easy problem", "pros"));
    }

    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] strings = sentence.split(" ");
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].startsWith(searchWord)) {
                    return i + 1;
                }
            }
            return -1;
        }
    }
}
