package leetcode.weekly.OneSixNine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Kai
 */
public class AllElements {

    public static void main(String[] args) {
        Solution solution = new AllElements().new Solution();


    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> order1 = new ArrayList<>();
            LRD(root1, order1);
            List<Integer> order2 = new ArrayList<>();
            LRD(root2, order2);

            List<Integer> res = new ArrayList<>();
            int len1 = order1.size();
            int len2 = order2.size();
            int i = 0, j = 0;
            while (i < len1 && j<len2) {
                if(order1.get(i) < order2.get(j)) {
                    res.add(order1.get(i));
                    i++;
                } else {
                    res.add(order2.get(j));
                    j++;
                }
            }
            List<Integer> tmp;
            int x;
            if(i < len1) { tmp = order1; x = i;}
            else {tmp = order2; x = j;}
            for(; x < tmp.size(); x++) {
                res.add(tmp.get(x));
            }
            return res;
        }

        private void LRD(TreeNode node, List<Integer> res) {
            if(node == null) return;
            LRD(node.left, res);
            res.add(node.val);
            LRD(node.right, res);
        }
    }
}
