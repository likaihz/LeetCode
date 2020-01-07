//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串
  
package leetcode.editor.cn;
public class ValidPalindrome{
      public static void main(String[] args) {
           Solution solution = new ValidPalindrome().new Solution();
          System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
          String s = "A12Bcd";
          System.out.println(s.toLowerCase());
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = new char[s.length()];
        int cnt = 0;
        for(char c: s.toCharArray()) {
            if(c >= 'A' && c <= 'Z') {
                chars[cnt++] = (char)('a'+(c-'A'));
            }else if(c >= '0' && c<= '9' || c>='a' && c<='z'){
                chars[cnt++] = c;
            }
        }
        for(int i = 0; i<cnt/2; i++) {
            if(chars[i] != chars[cnt-i-1]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}