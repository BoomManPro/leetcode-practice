package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTestLCP_19 {
//小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 `leaves`， 字符串 `leaves` 仅包含小写字符 `r` 和 `
//y`， 其中字符 `r` 表示一片红叶，字符 `y` 表示一片黄叶。
//出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替
//换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
//
//**示例 1：**
//>输入：`leaves = "rrryyyrryyyrr"`
//>
//>输出：`2`
//>
//>解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
//
//**示例 2：**
//>输入：`leaves = "ryr"`
//>
//>输出：`0`
//>
//>解释：已符合要求，不需要额外操作
//
//**提示：**
//- `3 <= leaves.length <= 10^5`
//- `leaves` 中只包含字符 `'r'` 和字符 `'y'` 👍 68 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimumOperations(String leaves) {
            int n = leaves.length();
            int[][] f = new int[n][3];
            // 0是前面都是红色  1是黄色 2是后面是红色
            f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
            //因为要保证每个部分最少为一片
            f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                int yellow = leaves.charAt(i) == 'y' ? 1 : 0;
                int red = leaves.charAt(i) == 'r' ? 1 : 0;
                f[i][0] = f[i - 1][0] + yellow;
                f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + red;
                if (i >= 2) {
                    f[i][2] = Math.min(f[i - 1][2], f[i - 1][1]) + yellow;
                }
            }
            return f[n - 1][2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.minimumOperations("rrryyyrryyyrr"));
            Assert.assertEquals(0, solution.minimumOperations("ryr"));
        }
    }
}