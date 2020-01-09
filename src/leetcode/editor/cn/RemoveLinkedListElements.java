//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表

  
package leetcode.editor.cn;
public class RemoveLinkedListElements{
      public static void main(String[] args) {
           Solution solution = new RemoveLinkedListElements().new Solution();
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode ptr = head;
        head = new ListNode(0);
        head.next = ptr;
        ListNode pre = head;
        while (ptr != null) {
            if(ptr.val == val) {
                pre.next = ptr.next;
            } else {
                pre = ptr;
            }
            ptr = ptr.next;
        }
        return head.next;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}