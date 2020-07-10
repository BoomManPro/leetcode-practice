package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest309 {
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 365 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int n = prices.length;
            int[][] f = new int[n][3];
            f[0][0] = -prices[0];
            for (int i = 1; i < n; i++) {
                int prev = i - 1;
                f[i][0] = Math.max(f[prev][0], f[prev][2] - prices[i]);
                f[i][1] = f[prev][0] + prices[i];
                f[i][2] = Math.max(f[prev][1], f[prev][2]);
            }
            return Math.max(f[n - 1][1], f[n - 1][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
        }
    }
}