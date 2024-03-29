package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest198 {

    //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2: 
//
// 输入: [2,7,9,3,1]    [1,2,3,4,5,6,7,8,9,10]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
// Related Topics 动态规划
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            }

            int[] dp = new int[len];
            dp[0] = nums[0];
            dp[1] = nums[1];

            for (int i = 2; i < len; i++) {
                //核心在于  当前位置取决于之前位置的最大值(i-2)||(i-3)
                if (i > 2) {
                    dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
                } else {
                    dp[i] = dp[i - 2] + nums[i];
                }
            }
            return Math.max(dp[len - 1], dp[len - 2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(4, solution.rob(new int[]{1, 2, 3, 1}));
            Assert.assertEquals(12, solution.rob(new int[]{2, 7, 9, 3, 1}));
        }
    }
}