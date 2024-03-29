package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
class SolutionTest326 {
//给定一个整数，写一个函数来判断它是否是 3 的幂次方。 
//
// 示例 1: 
//
// 输入: 27
//输出: true
// 
//
// 示例 2: 
//
// 输入: 0
//输出: false 
//
// 示例 3: 
//
// 输入: 9
//输出: true 
//
// 示例 4: 
//
// 输入: 45
//输出: false 
//
// 进阶： 
//你能不使用循环或者递归来完成本题吗？ 
// Related Topics 数学
    public static
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0 ) {
            return false;
        }
        while (n != 1) {
            if (n % 3 == 0) {
                n = n / 3;
            }else {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isPowerOfThree(27));
            Assert.assertTrue(solution.isPowerOfThree(9));
            Assert.assertFalse(solution.isPowerOfThree(0));
            Assert.assertFalse(solution.isPowerOfThree(45));
            Assert.assertTrue(solution.isPowerOfThree(1));
        }
    }
}