//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表
  
package leetcode.editor.cn;
public class SwapNodesInPairs{
      public static void main(String[] args) {
           Solution solution = new SwapNodesInPairs().new Solution();
           ListNode h = new ListNode(0);
           ListNode t = h;
           for(int i = 1; i <= 4; i++) {
                t.next = new ListNode(i);
                t = t.next;
           }
           h = h.next;
           t = h;
          while (t!= null) {
              System.out.println(t.val);
              t = t.next;
          }
          t = solution.swapPairs(h);
          while (t!= null) {
              System.out.println(t.val);
              t = t.next;
          }
      }

    private static class ListNode {
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode ptr = head;
        head = head.next;
        ListNode tmp;

        tmp = ptr.next.next;
        ptr.next.next = ptr;
        ptr.next = swapPairs(tmp);
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}