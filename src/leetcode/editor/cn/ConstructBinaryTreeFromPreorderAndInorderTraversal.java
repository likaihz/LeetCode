//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

  
package leetcode.editor.cn;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
          int[] preOrder = new int[]{3, 9, 20, 15, 7};
          int[] inOrder = new int[]{9, 3, 15, 20, 7};
          solution.buildTree(preOrder, inOrder);
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length < 1) return null;
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode build(int[] preOrder,
                           int[] inOrder,
                           int preStart,
                           int preEnd,
                           int inStart,
                           int inend) {
        if(preStart >= preEnd) return null;
        TreeNode node = new TreeNode(preOrder[preStart]);
        int rootIdx = -1;
        for (int i = inStart; i <= inend; i++) {
            if (inOrder[i] == preOrder[preStart]) {
                rootIdx = i;
                break;
            }
        }
        int leftLen = rootIdx-inStart;
        node.left = build(preOrder, inOrder, preStart + 1, preStart + rootIdx - inStart + 1, inStart, rootIdx);
        node.right = build(preOrder, inOrder, preStart + rootIdx - inStart + 1, preEnd, rootIdx + 1, inend);
        return node;
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