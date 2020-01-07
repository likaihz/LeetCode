//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学

  
package leetcode.editor.cn;
public class ExcelSheetColumnTitle{
      public static void main(String[] args) {
           Solution solution = new ExcelSheetColumnTitle().new Solution();
           for (char c = 'A'; c <= 'Z'; c++) {
               System.out.print("'"+c+"',");
           }
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        char[] voc = new char[] {'Z', 'A', 'B', 'C', 'D', 'E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'};
        while (n > 0) {
            sb.append(voc[n%26]);
            if(n%26==0) {
                n /= 26;
                n--;
            }
            else n /= 26;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}