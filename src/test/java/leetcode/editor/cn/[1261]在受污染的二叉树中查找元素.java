package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

class SolutionTest1261 {
//给出一个满足下述规则的二叉树：
//
//
// root.val == 0
// 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x +
//1
// 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x
//+ 2
//
//
// 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
//
// 请你先还原二叉树，然后实现 FindElements 类：
//
//
// FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
// bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
//
//
//
//
// 示例 1：
//
//
//
// 输入：
//["FindElements","find","find"]
//[[[-1,null,-1]],[1],[2]]
//输出：
//[null,false,true]
//解释：
//FindElements findElements = new FindElements([-1,null,-1]);
//findElements.find(1); // return False
//findElements.find(2); // return True
//
// 示例 2：
//
//
//
// 输入：
//["FindElements","find","find","find"]
//[[[-1,-1,-1,-1,-1]],[1],[3],[5]]
//输出：
//[null,true,true,false]
//解释：
//FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
//findElements.find(1); // return True
//findElements.find(3); // return True
//findElements.find(5); // return False
//
// 示例 3：
//
//
//
// 输入：
//["FindElements","find","find","find","find"]
//[[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
//输出：
//[null,true,false,false,true]
//解释：
//FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
//findElements.find(2); // return True
//findElements.find(3); // return False
//findElements.find(4); // return False
//findElements.find(5); // return True
//
//
//
//
// 提示：
//
//
// TreeNode.val == -1
// 二叉树的高度不超过 20
// 节点的总数在 [1, 10^4] 之间
// 调用 find() 的总次数在 [1, 10^4] 之间
// 0 <= target <= 10^6
//
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 设计 | 哈希表 | 二叉树
//
// 👍 76, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    class FindElements {
        Set<Integer> sets = new HashSet<>();

        public FindElements(TreeNode root) {
            root.val = 0;
            sets.add(root.val);
            dfs(root);
        }

        private void dfs(TreeNode root) {
            if (root.left != null) {
                root.left.val = root.val * 2 + 1;
                sets.add(root.left.val);
                dfs(root.left);
            }
            if (root.right != null) {
                root.right.val = root.val * 2 + 2;
                sets.add(root.right.val);
                dfs(root.right);
            }
        }

        public boolean find(int target) {
            return sets.contains(target);
        }
    }

    /**
     * Your FindElements object will be instantiated and called as such:
     * FindElements obj = new FindElements(root);
     * boolean param_1 = obj.find(target);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            FindElements findElements = new FindElements(TreeNode.getTreeNode(new Integer[]{-1, null, -1}));
            Assert.assertFalse(findElements.find(1));
            Assert.assertTrue(findElements.find(2));
        }

    }
}
