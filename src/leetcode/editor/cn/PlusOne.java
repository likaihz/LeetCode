//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组
  
package leetcode.editor.cn;
public class PlusOne{
      public static void main(String[] args) {
           Solution solution = new PlusOne().new Solution();
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = null;
        if(digits[digits.length-1] == 9) {
            for(int i = digits.length-1; i >= 0; i--) {
                if(digits[i] != 9) {
                    res = digits.clone();
                    res[i] = digits[i]+1;
                    for(int j = i+1; j < digits.length; j++) {
                        res[j] = 0;
                    }
                    break;
                }
            }
            if(res == null) {
                res = new int[digits.length + 1];
                res[0] = 1;
                for(int i = 1; i < res.length; i++) {
                    res[i] = 0;
                }
            }
        } else {
            res = digits.clone();
            res[digits.length-1] = digits[digits.length-1]+1;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}