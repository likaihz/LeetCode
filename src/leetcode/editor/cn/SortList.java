//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表

  
package leetcode.editor.cn;
public class SortList{
      public static void main(String[] args) {
           Solution solution = new SortList().new Solution();
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

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution2 {
        public ListNode sortList(ListNode head) {
            // 增加头结点
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode preNode = pre;

        /*循环增加排序子链表的长度
        (preNode = sortSubList(preNode, len)) != null 作为边界条件，
            意为第一次调用sortSubList就返回null，说明链表长度小于len*2，可以结束排序
        */
            for (int len = 1; (preNode = sortSubList(preNode, len)) != null; len *= 2){
                while (preNode != null){
                    preNode = sortSubList(preNode, len);
                }
                preNode = pre;
            }
            return pre.next;
        }

        // 返回排序后的链表的最后一个节点
        ListNode sortSubList(ListNode pre, int num){
            //当前指针位置
            int fstnum = 0, lstnum = 0;
            //当前节点
            ListNode fst = pre.next, lst = fst;

            //找到lst节点位置
            for (int i = 0; i < num; i++){
                //fst长度不够，直接返回null，此时子链表已经是排好序的
                if (lst == null)
                    return null;
                lst = lst.next;
            }
            //比较，终止条件为fstnum或lastnum大于子链表长度，或者lsatnum到达链表末尾
            while (fstnum < num && lstnum < num && lst != null){
                if (fst.val <= lst.val){
                    pre.next = fst;
                    fst = fst.next;
                    fstnum++;
                }
                else{
                    pre.next = lst;
                    lst = lst.next;
                    lstnum++;
                }
                pre = pre.next;
            }

            //如果fst子链表还有剩余节点，接到当前节点后面
            if (fstnum < num){
                pre.next = fst;
                //让当前节点走到子链表末尾
                for (; fstnum < num; fstnum++)
                    pre = pre.next;
                //接上后面的链表
                pre.next = lst;
            }

            //和上面类似，此时还需考虑last子链表长度小于num的情况
            if (lstnum < num && lst != null){
                pre.next = lst;
                for (; lstnum < num && pre != null; lstnum++)
                    pre = pre.next;
            }

            //返回最后一个节点，作为下次排序的pre
            return pre;
        }
    }
}