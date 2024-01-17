package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest2744 {
//给你一个下标从 0 开始的数组 words ，数组中包含 互不相同 的字符串。
//
// 如果字符串 words[i] 与字符串 words[j] 满足以下条件，我们称它们可以匹配：
//
//
// 字符串 words[i] 等于 words[j] 的反转字符串。
// 0 <= i < j < words.length
//
//
// 请你返回数组 words 中的 最大 匹配数目。
//
// 注意，每个字符串最多匹配一次。
//
//
//
// 示例 1：
//
//
//输入：words = ["cd","ac","dc","ca","zz"]
//输出：2
//解释：在此示例中，我们可以通过以下方式匹配 2 对字符串：
//- 我们将第 0 个字符串与第 2 个字符串匹配，因为 word[0] 的反转字符串是 "dc" 并且等于 words[2]。
//- 我们将第 1 个字符串与第 3 个字符串匹配，因为 word[1] 的反转字符串是 "ca" 并且等于 words[3]。
//可以证明最多匹配数目是 2 。
//
//
// 示例 2：
//
//
//输入：words = ["ab","ba","cc"]
//输出：1
//解释：在此示例中，我们可以通过以下方式匹配 1 对字符串：
//- 我们将第 0 个字符串与第 1 个字符串匹配，因为 words[1] 的反转字符串 "ab" 与 words[0] 相等。
//可以证明最多匹配数目是 1 。
//
//
// 示例 3：
//
//
//输入：words = ["aa","ab"]
//输出：0
//解释：这个例子中，无法匹配任何字符串。
//
//
//
//
// 提示：
//
//
// 1 <= words.length <= 50
// words[i].length == 2
// words 包含的字符串互不相同。
// words[i] 只包含小写英文字母。
//
//
// Related Topics数组 | 哈希表 | 字符串 | 模拟
//
// 👍 34, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumNumberOfStringPairs(String[] words) {
            int n = words.length;
            boolean[] used = new boolean[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (used[i] || used[j]) {
                        continue;
                    }
                    if (words[i].length() != words[j].length()) {
                        continue;
                    }
                    if (eq(words[i], words[j])) {
                        ans++;
                        used[i] = true;
                        used[j] = true;
                    }
                }
            }
            return ans;
        }

        private boolean eq(String s1, String s2) {
            int n = s1.length();
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt(n - i - 1)) {
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
            Assert.assertEquals(2, solution.maximumNumberOfStringPairs(new String[]{"cd", "ac", "dc", "ca", "zz"}));
            Assert.assertEquals(1, solution.maximumNumberOfStringPairs(new String[]{"ab", "ba", "cc"}));
            Assert.assertEquals(0, solution.maximumNumberOfStringPairs(new String[]{"aa", "ab"}));
        }

    }
}
