//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 说明： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 
// Related Topics 堆 哈希表

  
package leetcode.editor.cn;

import java.util.*;

public class TopKFrequentElements{
      public static void main(String[] args) {
           Solution solution = new TopKFrequentElements().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Queue<Item> heap = new PriorityQueue<>(k, Comparator.comparingInt(Item::getCnt));
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (heap.size() < k) {
                heap.add(new Item(entry.getKey(), entry.getValue()));
            } else if (heap.peek().getCnt() < entry.getValue()) {
                heap.poll();
                heap.add(new Item(entry.getKey(), entry.getValue()));
            }
        }

        List<Integer> res = new ArrayList<>();
        for (Item item : heap) {
            res.add(item.getVal());
        }
        return res;
    }

    class Item {
        int val;
        int cnt;

        public Item(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
        public int getVal() {return val;}
        public int getCnt() {return cnt;}

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return item.val == this.val;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}