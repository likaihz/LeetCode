//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计

  
package leetcode.editor.cn;

public class YongLiangGeZhanShiXianDuiLieLcof{
      public static void main(String[] args) {
//           Solution solution = new YongLiangGeZhanShiXianDuiLieLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class CQueue {
          class Node{
              int val;
              Node next;

              public Node(int v) {
                  this.val = v;
                  next = null;
              }
          }

          private Node head;
          private Node tail;
    public CQueue() {
        head = null;
        tail = null;
    }
    
    public void appendTail(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
    }
    
    public int deleteHead() {
        if(head == null) return -1;
        int res = head.val;
        head = head.next;
        return res;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}