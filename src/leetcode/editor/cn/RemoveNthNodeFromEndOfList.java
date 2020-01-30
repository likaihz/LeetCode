 //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针

  
package leetcode.editor.cn;
public class RemoveNthNodeFromEndOfList{
      public static void main(String[] args) {
           Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ahead = head;
        for (int i = 1; i < n; i++) {
            ahead = ahead.next;
        }
        if(ahead.next == null) return head.next;
        ListNode ptr = head, pre = head;
        while (ahead.next != null) {
            pre = ptr;
            ptr = pre.next;
            ahead = ahead.next;
        }
        pre.next = ptr.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}