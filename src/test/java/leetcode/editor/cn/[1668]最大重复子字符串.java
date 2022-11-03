package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest1668 {
//给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为
// k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 
//为 0 。 
//
// 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。 
//
// 
//
// 示例 1： 
//
// 
//输入：sequence = "ababc", word = "ab"
//输出：2
//解释："abab" 是 "ababc" 的子字符串。
// 
//
// 示例 2： 
//
// 
//输入：sequence = "ababc", word = "ba"
//输出：1
//解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
// 
//
// 示例 3： 
//
// 
//输入：sequence = "ababc", word = "ac"
//输出：0
//解释："ac" 不是 "ababc" 的子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sequence.length <= 100 
// 1 <= word.length <= 100 
// sequence 和 word 都只包含小写英文字母。 
// 
//
// Related Topics 字符串 字符串匹配 👍 117 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRepeating(String sequence, String word) {
            int n = sequence.length();
            int[] dp = new int[n];
            for (int i = 0; i <= n - word.length(); i++) {
                if (isSubString(sequence, i, word)) {
                    dp[i] += 1 + (i >= word.length() ? dp[i - word.length()] : 0);
                }
            }
            return Arrays.stream(dp).max().orElse(0);
        }

        private boolean isSubString(String sequence, int i, String word) {
            int n = word.length();
            for (int p = 0; p < n; p++) {
                if (word.charAt(p) != sequence.charAt(p + i)) {
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
            Assert.assertEquals(2, solution.maxRepeating("ababc", "ab"));
            Assert.assertEquals(1, solution.maxRepeating("a", "a"));
        }

    }
}