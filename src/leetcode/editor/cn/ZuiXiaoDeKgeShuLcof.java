//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法

  
package leetcode.editor.cn;

import java.util.*;

public class ZuiXiaoDeKgeShuLcof{
      public static void main(String[] args) {
           Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
           int[] my = {0,0,1,1,1,2,3,2,1,1,2,2,3,2,4,5,2,2,2,1,5,7,5,13,7,12,12,15,8,10,10,6,7,6,6,8,10,8,10,11,7,8,9,12,9,7,15,27,20,28,26,17,18,16,19,27,32,23,19,22,22,17,22,31,26,19,19,22,29,33,42,44,39,36,35};
           int[] ans ={0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,4,5,5,5,6,6,6,7,7,7,7,7,8,8,8,8,9,9,10,10,10,10,11,12,12,12,13,15,15,16,17,17,18,19,19,19,19,20,22,22,22,22,23,26,26,27,27,28,29,31,32,33,35,36,39,40,42};

          Map<Integer, Integer> rec1 = new HashMap<>();
          Map<Integer, Integer> rec2 = new HashMap<>();

          for (int i : my) {
              rec1.put(i, rec1.getOrDefault(i, 0)+1);
          }

          for (int i : ans) {
              rec2.put(i, rec2.getOrDefault(i, 0)+1);
          }
          System.out.println(rec1);
          System.out.println(rec2);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if( k < 1) return new int[0];
        partition(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }
    private int partition(int[] arr, int lo, int hi, int k) {
        if(hi-lo+1 == k) return hi+1;

        int i = lo, j = hi+1;
        int v = arr[lo];
        int tmp;
        while (true) {
            while (arr[++i] < v) if(i == hi) break;
            while (arr[--j] > v) if(j == lo) break;
            if(i >= j) break;
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        arr[lo] = arr[j];
        arr[j] = v;

        if(j-lo+1 == k) return j;
        else if(j-lo+1 > k) return partition(arr, lo, j, k);
        else return partition(arr, j + 1, hi, k - j + lo - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    class Solution2 {
        public int[] getLeastNumbers(int[] arr, int k) {
            if(k < 1) return new int[0];
            Queue<Integer> heap = new PriorityQueue<>(k);

            for (int i : arr) {
                heap.add(i);
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = heap.poll();

            }
            return res;

        }
    }
}