package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest514 {
//视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。 
//
// 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。 
//
// 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，
//以此逐个拼写完 key 中的所有字符。 
//
// 旋转 ring 拼出 key 字符 key[i] 的阶段中： 
//
// 
// 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符
// key[i] 。 
// 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段
//）, 直至完成所有拼写。 
// 
//
// 示例： 
//
// 
//
//
// 
//
// 输入: ring = "godding", key = "gd"
//输出: 4
//解释:
// 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。 
// 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
// 当然, 我们还需要1步进行拼写。
// 因此最终的输出是 4。
// 
//
// 提示： 
//
// 
// ring 和 key 的字符串长度取值范围均为 1 至 100； 
// 两个字符串中都只有小写字符，并且均可能存在重复字符； 
// 字符串 key 一定可以由字符串 ring 旋转拼出。 
// Related Topics 深度优先搜索 分治算法 动态规划 
// 👍 98 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        @SuppressWarnings("all")
        public int findRotateSteps(String ring, String key) {
            int m = key.length();
            int n = ring.length();
            List<Integer>[] dict = new List[26];
            for (int i = 0; i < 26; i++) {
                dict[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                dict[ring.charAt(i) - 'a'].add(i);
            }
            int[][] dp = new int[m][n];
            for (int[] ints : dp) {
                Arrays.fill(ints, 0x3f3f3f);
            }
            for (int i : dict[key.charAt(0) - 'a']) {
                dp[0][i] = Math.min(i, n - i) + 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j : dict[key.charAt(i) - 'a']) {
                    for (int k : dict[key.charAt(i - 1) - 'a']) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + 1 + Math.min(Math.abs(j - k), n - Math.abs(j - k)));
                    }
                }
            }
            return Arrays.stream(dp[m - 1]).min().getAsInt();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(4, solution.findRotateSteps("godding", "gd"));
        }
    }
}