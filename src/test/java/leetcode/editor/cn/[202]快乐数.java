package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

class SolutionTest202 {
    //编写一个算法来判断一个数是不是“快乐数”。
//
// 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。 
//
// 示例: 
//
// 输入: 19
//输出: true
//解释: 
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学
    public static


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {

            Set<Integer> dict = new HashSet<>();
            dict.add(n);
            while (n != 1) {
                n = doHappy(n);
                if (dict.contains(n)) {
                    return false;
                }
                dict.add(n);
            }
            return true;
        }

        public int doHappy(int n) {
            int happy = 0;
            int remainder = 0;
            while (n > 0) {
                remainder = n % 10;
                happy += remainder * remainder;
                n = n / 10;
            }
            return happy;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isHappy(19));
        }
    }
}