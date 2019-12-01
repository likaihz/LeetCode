//给定两个二进制字符串，返回他们的和（用二进制表示）。 
//
// 输入为非空字符串且只包含数字 1 和 0。 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
// Related Topics 数学 字符串
  
package leetcode.editor.cn;
public class AddBinary{
      public static void main(String[] args) {
           Solution solution = new AddBinary().new Solution();
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] l, s;
        if(a.length() > b.length()) {
            l = a.toCharArray();
            StringBuilder builder = new StringBuilder(b);
            for(int i = 0; i < a.length()-b.length(); i++) {
                builder.insert(0, '0');
            }
            s = builder.toString().toCharArray();
        } else {
            l = b.toCharArray();
            StringBuilder builder = new StringBuilder(a);
            for(int i = 0; i < b.length()-a.length(); i++) {
                builder.insert(0, '0');
            }
            s = builder.toString().toCharArray();
        }
        int co = 0;
        int tmp;
        for(int i = l.length-1, j = s.length-1; j>=0; i--,j--) {
            tmp = co+(l[i]-'0')+(s[j]-'0');
            if(tmp == 0) {
                co = 0;
                sb.append("0");
            } else if(tmp == 1) {
                co = 0;
                sb.append("1");
            } else if(tmp == 2) {
                co = 1;
                sb.append("0");
            } else if(tmp == 3) {
                co = 1;
                sb.append("1");
            }
        }
        if(co == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}