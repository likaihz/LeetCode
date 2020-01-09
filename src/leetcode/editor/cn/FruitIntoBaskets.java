//在一排树中，第 i 棵树产生 tree[i] 型的水果。 
//你可以从你选择的任何树开始，然后重复执行以下步骤： 
//
// 
// 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。 
// 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。 
// 
//
// 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。 
//
// 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。 
//用这个程序你能收集的水果总量是多少？ 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,1]
//输出：3
//解释：我们可以收集 [1,2,1]。
// 
//
// 示例 2： 
//
// 输入：[0,1,2,2]
//输出：3
//解释：我们可以收集 [1,2,2].
//如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
// 
//
// 示例 3： 
//
// 输入：[1,2,3,2,2]
//输出：4
//解释：我们可以收集 [2,3,2,2].
//如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
// 
//
// 示例 4： 
//
// 输入：[3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：我们可以收集 [1,2,1,1,2].
//如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 个水果。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tree.length <= 40000 
// 0 <= tree[i] < tree.length 
// 
// Related Topics 双指针

  
package leetcode.editor.cn;
public class FruitIntoBaskets{
      public static void main(String[] args) {
           Solution solution = new FruitIntoBaskets().new Solution();
          System.out.println(solution.totalFruit(new int[]{1,0,1,4,1,4,1,2,3}));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalFruit(int[] tree) {
        // 两个篮子里装的类型
        int type1 = -1, type2 = -1;
        // 两个篮子里装的数量
        int cnt1 = 0, cnt2 = 0;
        // 两个篮子中的水果最后一次出现的index
        int last1 = -1, last2 = -1;

        int max = 0;
        for(int i = 0; i < tree.length; i++) {
            if(type1 < 0) {
                type1 = tree[i];
                cnt1 = 1;
                last1 = i;
            } else if(type2 < 0 && tree[i] != type1) {
                type2 = tree[i];
                cnt2 = 1;
                last2 = i;
            } else if (type1 == tree[i]) {
                cnt1++;
                last1 = i;
            } else if(type2 == tree[i]) {
                cnt2++;
                last2 = i;
            } else {
                max = Math.max(max, cnt1+cnt2);
                if(last1 > last2) {
                    cnt1 = last1-last2;
                    type2 = tree[i];
                    cnt2 = 1;
                    last2 = i;
                } else {
                    cnt2 = last2-last1;
                    type1 = tree[i];
                    cnt1 = 1;
                    last1 = i;
                }
            }
        }
        return Math.max(max, cnt1+cnt2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}