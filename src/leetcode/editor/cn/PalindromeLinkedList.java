//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针

  
package leetcode.editor.cn;
public class PalindromeLinkedList{
      public static void main(String[] args) {
           Solution solution = new PalindromeLinkedList().new Solution();
          ListNode n1 = new ListNode(1), n2 = new ListNode(2), n3 = new ListNode(3);
          n1.next = n2;
          n2.next = n3;
          n3.next = null;

          System.out.println(solution.isPalindrome(n1));
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        ListNode pre = null;
        ListNode left = null, right = null;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                ListNode tmp = slow.next;
                slow.next = pre;
                pre = slow;
                slow = tmp;
                fast = fast.next;
            } else {
                right = slow.next;
                slow.next = pre;
                left = slow;
            }
        }
        if (left == null) {
            left = pre;
            right = slow.next;
        }

        while (left != null) {
            if(left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}