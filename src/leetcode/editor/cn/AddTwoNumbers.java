//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学
  
package leetcode.editor.cn;
public class AddTwoNumbers{
      public static void main(String[] args) {
           Solution solution = new AddTwoNumbers().new Solution();
      }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode x = res;
        int co = 0;
        while(l1!=null && l2!=null) {
            x.next = new ListNode((l1.val + l2.val+co) % 10);
            co = (l1.val+l2.val+co)/10;
            l1 = l1.next;
            l2 = l2.next;
            x = x.next;
        }
        ListNode tmp = null;
        if(l1 != null) tmp = l1;
        else tmp = l2;
        if (tmp != null) {
            while(tmp != null) {
                x.next = new ListNode((tmp.val+co)%10);
                co = (tmp.val + co) / 10;
                tmp = tmp.next;
                x = x.next;
            }
        }
        if (co != 0) {
            x.next = new ListNode(co);
        }
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}