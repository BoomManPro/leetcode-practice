package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest367 {
//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPerfectSquare(int num) {
            if (num == 0) {
                return false;
            }
            if (num == 1) {
                return true;
            }
            if (num < 4) {
                return false;
            }
            long l = 2;
            long r = num >> 1;
            while (l <= r) {
                long mid = ((r - l) >> 1) + l;
                long value = mid * mid;
                if (value == num) {
                    return true;
                }
                if (value < num) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isPerfectSquare(16));
            Assert.assertFalse(solution.isPerfectSquare(14));
            Assert.assertTrue(solution.isPerfectSquare(808201));
        }
    }
}