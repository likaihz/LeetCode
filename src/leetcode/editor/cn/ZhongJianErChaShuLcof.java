//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
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
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归

  
package leetcode.editor.cn;
public class ZhongJianErChaShuLcof{
      public static void main(String[] args) {
           Solution solution = new ZhongJianErChaShuLcof().new Solution();
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
    int[] preOrder;
    int[] inOrder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        this.inOrder = inorder;
        int len = preorder.length;
        return build(0, len - 1, 0, len - 1);
    }

    private TreeNode build(int preL, int preR, int inL, int inR) {
        if(preL > preR) return null;
        if(preL == preR) return new TreeNode(preOrder[preL]);
        TreeNode root = new TreeNode(preOrder[preL]);
        int lenL = 0;
        for (int i = inL; i <= inR; i++) {
            if(inOrder[i] == root.val) break;
            lenL++;
        }

        root.left = build(preL+1, preL+lenL, inL, inL+lenL-1);
        root.right = build(preL+lenL+1, preR, inL+lenL+1, inR);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}