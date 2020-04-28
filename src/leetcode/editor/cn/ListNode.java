package leetcode.editor.cn;

/**
 * @author Li Kai
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode createList(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode ptr = head;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            ptr.next = node;
            ptr = node;
        }
        return head.next;
    }

    public static void print(ListNode list) {
        if(list == null) {
            System.out.println("empty list");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.val);
        list = list.next;
        while (list != null) {
            sb.append(" -> ").append(list.val);
            list = list.next;
        }

        System.out.println(sb.toString());

    }
}
