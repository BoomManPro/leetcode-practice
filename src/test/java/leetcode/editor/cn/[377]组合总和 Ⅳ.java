package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest377 {
//给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。 
//
// 示例: 
//
// 
//nums = [1, 2, 3]
//target = 4
//
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//
//请注意，顺序不同的序列被视作不同的组合。
//
//因此输出为 7。
// 
//
// 进阶： 
//如果给定的数组中含有负数会怎么样？ 
//问题会产生什么变化？ 
//我们需要在题目中添加什么限制来允许负数的出现？ 
//
// 致谢： 
//特别感谢 @pbrother 添加此问题并创建所有测试用例。 
// Related Topics 动态规划 
// 👍 194 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int combinationSum4(int[] nums, int target) {
            if (nums == null || nums.length == 0 || target == 0) {
                return 0;
            }
            int[] f = new int[target + 1];
            f[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (num <= i) {
                        f[i] += f[i - num];
                    }
                }
            }
            return f[target];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(7, solution.combinationSum4(new int[]{1, 2, 3}, 4));
            Assert.assertEquals(1132436852, solution.combinationSum4(new int[]{2, 1, 3}, 35));
        }
    }
}