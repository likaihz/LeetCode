//对链表进行插入排序。 
//
// 
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 
//
// 
//
// 插入排序算法： 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2： 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// 
// Related Topics 排序 链表

  
package leetcode.editor.cn;
public class InsertionSortList{
      public static void main(String[] args) {
           Solution solution = new InsertionSortList().new Solution();
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
    public ListNode insertionSortList(ListNode head) {
        return sortList(head);
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head, fast = head;
        ListNode pre = head;

        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if(fast != null) fast = fast.next;
        }

        ListNode l1 = head, l2 = slow;
        pre.next = null;
        l1 = sortList(l1);
        l2 = sortList(l2);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode ptr = head;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }

        if(l1 != null) ptr.next = l1;
        else if(l2 != null) ptr.next = l2;

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    class Solution2 {

        public ListNode insertionSortList(ListNode head) {
            ListNode newHead = new ListNode(-1);
            ListNode ptr = head;
            ListNode crt,p;
            while (ptr != null) {
                crt = ptr;
                ptr = ptr.next;
                p = newHead;
                while (p.next != null && p.next.val < crt.val){p=p.next;}
                crt.next = p.next;
                p.next = crt;
            }
            return newHead.next;
        }
    }


    class Solution3 {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(0), pre;
            dummy.next = head;
            while(head != null && head.next != null){
                if(head.val < head.next.val){
                    head = head.next;
                    continue;
                }
                pre = dummy;
                while(pre.next.val < head.next.val) pre = pre.next;
                ListNode curr = head.next;
                head.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            return dummy.next;
        }
    }
}