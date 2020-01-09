//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表

  
package leetcode.editor.cn;
public class IsomorphicStrings{
      public static void main(String[] args) {
           Solution solution = new IsomorphicStrings().new Solution();
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[260];
        int cnt = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < 260; i++) map[i] = -1;

        for(char c: s.toCharArray()) {
            if(map[c] >= 0) {
                sb1.append(map[c]);
            } else {
                cnt++;
                map[c] = cnt;
                sb1.append(map[c]);
            }
        }
        for(int i = 0; i < 260; i++) map[i] = -1;
        cnt = 0;
        for(char c: t.toCharArray()) {
            if(map[c] >= 0) {
                sb2.append(map[c]);
            } else {
                cnt++;
                map[c] = cnt;
                sb2.append(map[c]);
            }
        }
        return sb1.toString().equals(sb2.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}