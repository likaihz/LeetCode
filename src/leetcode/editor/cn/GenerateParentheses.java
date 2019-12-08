//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法
  
package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses{
      public static void main(String[] args) {
           Solution solution = new GenerateParentheses().new Solution();
          solution.generateParenthesis(3);
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        traceback(res, "", n, 0, 0);
        return res;
    }

    private void traceback(List<String> res, String s, int n, int open, int close) {
        if(open == close && open+close == 2*n) {
            res.add(s);
        }
        if(open < n) {
            traceback(res, s+'(', n, open+1, close);
        }
        if(close < n && close<open) {
            traceback(res, s+')', n, open, close+1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}