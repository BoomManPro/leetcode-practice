package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

class SolutionTest2281 {
////作为国王的统治者，你有一支巫师军队听你指挥。 
////
//// 给你一个下标从 0 开始的整数数组 strength ，其中 strength[i] 表示第 i 位巫师的力量值。对于连续的一组巫师（也就是这些巫师的
//力量
////值是 strength 的 子数组），总力量 定义为以下两个值的 乘积 ： 
////
//// 
//// 巫师中 最弱 的能力值。 
//// 组中所有巫师的个人力量值 之和 。 
//// 
////
//// 请你返回 所有 巫师组的 总 力量之和。由于答案可能很大，请将答案对 10⁹ + 7 取余 后返回。 
////
//// 子数组 是一个数组里 非空 连续子序列。 
////
//// 
////
//// 示例 1： 
////
//// 输入：strength = [1,3,1,2]
////输出：44
////解释：以下是所有连续巫师组：
////- [1,3,1,2] 中 [1] ，总力量值为 min([1]) * sum([1]) = 1 * 1 = 1
////- [1,3,1,2] 中 [3] ，总力量值为 min([3]) * sum([3]) = 3 * 3 = 9
////- [1,3,1,2] 中 [1] ，总力量值为 min([1]) * sum([1]) = 1 * 1 = 1
////- [1,3,1,2] 中 [2] ，总力量值为 min([2]) * sum([2]) = 2 * 2 = 4
////- [1,3,1,2] 中 [1,3] ，总力量值为 min([1,3]) * sum([1,3]) = 1 * 4 = 4
////- [1,3,1,2] 中 [3,1] ，总力量值为 min([3,1]) * sum([3,1]) = 1 * 4 = 4
////- [1,3,1,2] 中 [1,2] ，总力量值为 min([1,2]) * sum([1,2]) = 1 * 3 = 3
////- [1,3,1,2] 中 [1,3,1] ，总力量值为 min([1,3,1]) * sum([1,3,1]) = 1 * 5 = 5
////- [1,3,1,2] 中 [3,1,2] ，总力量值为 min([3,1,2]) * sum([3,1,2]) = 1 * 6 = 6
////- [1,3,1,2] 中 [1,3,1,2] ，总力量值为 min([1,3,1,2]) * sum([1,3,1,2]) = 1 * 7 = 7
////所有力量值之和为 1 + 9 + 1 + 4 + 4 + 4 + 3 + 5 + 6 + 7 = 44 。
//// 
////
//// 示例 2： 
////
//// 输入：strength = [5,4,6]
////输出：213
////解释：以下是所有连续巫师组：
////- [5,4,6] 中 [5] ，总力量值为 min([5]) * sum([5]) = 5 * 5 = 25
////- [5,4,6] 中 [4] ，总力量值为 min([4]) * sum([4]) = 4 * 4 = 16
////- [5,4,6] 中 [6] ，总力量值为 min([6]) * sum([6]) = 6 * 6 = 36
////- [5,4,6] 中 [5,4] ，总力量值为 min([5,4]) * sum([5,4]) = 4 * 9 = 36
////- [5,4,6] 中 [4,6] ，总力量值为 min([4,6]) * sum([4,6]) = 4 * 10 = 40
////- [5,4,6] 中 [5,4,6] ，总力量值为 min([5,4,6]) * sum([5,4,6]) = 4 * 15 = 60
////所有力量值之和为 25 + 16 + 36 + 36 + 40 + 60 = 213 。
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= strength.length <= 10⁵ 
//// 1 <= strength[i] <= 10⁹ 
//// 
//// 👍 40 👎 0
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = (int) 1e9 + 7;

        public int totalStrength(int[] nums) {
            int n = nums.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }
            int[] ss = new int[n + 2];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                ss[i + 2] = (ss[i + 1] + sum) % MOD;
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                int l = left[i];
                int r = right[i];
                long tot = ((long) (i - l) * (ss[r + 1] - ss[i + 1]) - (long) (r - i) * (ss[i + 1] - ss[l + 1])) % MOD;
                ans = (ans + nums[i] * tot) % MOD;
            }
            return (int) ((ans + MOD) % MOD);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(44, solution.totalStrength(new int[]{1, 3, 1, 2}));
        }

    }
}