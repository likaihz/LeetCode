//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MinStack{
      public static void main(String[] args) {

      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack2 {

    /** initialize your data structure here. */
    List<Integer> list = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    public MinStack2() {
        
    }
    
    public void push(int x) {
        list.add(x);
        if(x < min) min = x;
    }
    
    public void pop() {
        int x = list.remove(list.size()-1);
        if(x == min) {
            min = Integer.MAX_VALUE;
            for(int i: list) {
                if(i < min) min = i;
            }
        }
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}