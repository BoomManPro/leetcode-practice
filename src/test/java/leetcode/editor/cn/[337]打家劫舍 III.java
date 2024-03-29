package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest337 {
//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 
// 👍 462 👎 0

    public static
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

        public int rob(TreeNode root) {
            int[] result = robInternal(root);
            return Math.max(result[0], result[1]);
        }

        private int[] robInternal(TreeNode root) {
            //0代表不偷 1代表偷
            int[] result = new int[2];
            if (root == null) {
                return result;
            }
            int[] left = robInternal(root.left);
            int[] right = robInternal(root.right);
            result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            result[1] = left[0] + right[0] + root.val;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(7, solution.rob(TreeNode.getTreeNode(new Integer[]{3, 2, 3, null, 3, null, 1})));
            Assert.assertEquals(9, solution.rob(TreeNode.getTreeNode(new Integer[]{3, 4, 5, 1, 3, null, 1})));
        }
    }
}