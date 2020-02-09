package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Kai
 */
public class CommonUtils {
    public static TreeNode genBinTree(Integer[] x) {
        if(x.length == 0) return null;
        TreeNode root = new TreeNode(x[0]);
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int ptrInList = 0, ptrInArr = 1;
        while (ptrInArr < x.length) {
            TreeNode crt = list.get(ptrInList);
            if(x[ptrInArr] != null) {
                crt.left = new TreeNode(x[ptrInArr]);
                list.add(crt.left);
            }
            ptrInArr++;
            if (ptrInArr < x.length) {
                if(x[ptrInArr] != null) {
                    crt.right = new TreeNode(x[ptrInArr]);
                    list.add(crt.right);
                }
                ptrInArr++;
            }
            ptrInList ++;

        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] x = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode treeNode = genBinTree(x);
        System.out.println(treeNode);
    }
}
