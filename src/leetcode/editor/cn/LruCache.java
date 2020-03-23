//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计

  
package leetcode.editor.cn;

import java.util.LinkedHashMap;

public class LruCache{
      public static void main(String[] args) {
//          LRUCache cache = new LRUCache(2);
//          cache.put(2, 1);
//          cache.put(1, 2);
//          cache.put(2, 3);
//          cache.put(4, 1);
//          cache.get(1);
//          cache.get(2);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class LRUCache {
          private int capacity;
          private LinkedHashMap<Integer, Integer> map;
          public LRUCache(int capacity) {
              this.capacity = capacity;
              map = new LinkedHashMap<>(capacity / 2 * 3);
          }

          public int get(int key) {
              if (map.containsKey(key)) {
                  int v = map.get(key);
                  map.remove(key);
                  map.put(key, v);
                  return v;
              }
              return -1;
          }

          public void put(int key, int value) {
              if (map.size() >= capacity && !map.containsKey(key)) {
                  map.remove(map.keySet().iterator().next());
                  map.put(key, value);
              } else if(map.containsKey(key)) {
                  map.remove(key);
                  map.put(key, value);
              } else{
                  map.put(key, value);
              }
          }

      }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}