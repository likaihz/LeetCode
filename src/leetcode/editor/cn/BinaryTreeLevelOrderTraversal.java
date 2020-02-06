//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<TreeNode> crtLayer = new ArrayList<>();
        List<TreeNode> nextLayer = new ArrayList<>();
        List<Integer> tmp;
        crtLayer.add(root);
        while (!crtLayer.isEmpty()) {
            tmp = new ArrayList<>();
            nextLayer = new ArrayList<>();
            for (TreeNode node : crtLayer) {
                tmp.add(node.val);
                if(node.left != null) nextLayer.add(node.left);
                if(node.right != null) nextLayer.add(node.right);
            }
            res.add(tmp);
            crtLayer = nextLayer;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
}