//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber{
      public static void main(String[] args) {
           Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
          String s = "0";
          System.out.println(solution.letterCombinations("23"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() < 1) return res;
        String[] phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits.toCharArray(), 0,  new StringBuilder(), res, phone);
        return res;
    }

    private void dfs(char[] digits, int ptr, StringBuilder sb, List<String> res, String[] phone)  {
        if(ptr >= digits.length) {
            res.add(sb.toString());
            return;
        }
        char c = digits[ptr];
        for (char ch : phone[c - '0'].toCharArray()) {
            sb.append(ch);
            dfs(digits, ptr+1, sb, res, phone);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}