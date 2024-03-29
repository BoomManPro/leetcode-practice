package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class SolutionTest767 {
//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 149 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorganizeString(String S) {
            if (S.length() < 2) {
                return S;
            }
            int[] counts = new int[26];
            int maxCount = 0;
            int length = S.length();
            for (int i = 0; i < length; i++) {
                char c = S.charAt(i);
                counts[c - 'a']++;
                maxCount = Math.max(maxCount, counts[c - 'a']);
            }
            if (maxCount > (length + 1) / 2) {
                return "";
            }
            char[] reorganizeArray = new char[length];
            int evenIndex = 0, oddIndex = 1;
            int halfLength = length / 2;
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
                    reorganizeArray[oddIndex] = c;
                    counts[i]--;
                    oddIndex += 2;
                }
                while (counts[i] > 0) {
                    reorganizeArray[evenIndex] = c;
                    counts[i]--;
                    evenIndex += 2;
                }
            }
            return new String(reorganizeArray);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("aba", solution.reorganizeString(solution.reorganizeString("aab")));
            Assert.assertEquals("", solution.reorganizeString(solution.reorganizeString("aaab")));
        }
    }
}