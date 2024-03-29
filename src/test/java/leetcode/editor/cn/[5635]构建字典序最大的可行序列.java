package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest5635 {
//给你一个整数 n ，请你找到满足下面条件的一个序列： 
//
// 
// 整数 1 在序列中只出现一次。 
// 2 到 n 之间每个整数都恰好出现两次。 
// 对于每个 2 到 n 之间的整数 i ，两个 i 之间出现的距离恰好为 i 。 
// 
//
// 序列里面两个数 a[i] 和 a[j] 之间的 距离 ，我们定义为它们下标绝对值之差 |j - i| 。 
//
// 请你返回满足上述条件中 字典序最大 的序列。题目保证在给定限制条件下，一定存在解。 
//
// 一个序列 a 被认为比序列 b （两者长度相同）字典序更大的条件是： a 和 b 中第一个不一样的数字处，a 序列的数字比 b 序列的数字大。比方说，[0
//,1,9,0] 比 [0,1,5,6] 字典序更大，因为第一个不同的位置是第三个数字，且 9 比 5 大。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：[3,1,2,3,2]
//解释：[2,3,2,1,3] 也是一个可行的序列，但是 [3,1,2,3,2] 是字典序最大的序列。
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出：[5,3,1,4,3,5,2,4,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 递归 回溯算法 
// 👍 5 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] constructDistancedSequence(int n) {
            int len = 2 * n - 1;
            int[] ans = new int[2 * n - 1];
            boolean[] visited = new boolean[n + 1];
            dfs(ans, visited, n, 0, len);
            return ans;
        }


        private boolean dfs(int[] ans, boolean[] visited, int n, int index, int len) {
            if (index == len) {
                return true;
            }
            if (ans[index]!=0) {
                return dfs(ans, visited, n, index + 1, len);
            }
            for (int i = n; i > 0; i--) {
                if (visited[i]) {
                    continue;
                }
                if (i==1){
                    if (ans[index] == 0) {
                        ans[index] = 1;
                        visited[1] = true;
                        if (dfs(ans, visited, n, index + 1, len)) {
                            return true;
                        }else {
                            ans[index] = 0;
                            visited[1] = false;
                        }
                    }
                }

                if (ans[index] == 0 && i + index < len && ans[i + index] == 0) {
                    ans[index] = i;
                    ans[i + index] = i;
                    visited[i] = true;
                    if (dfs(ans, visited, n, index + 1, len)) {
                        return true;
                    } else {
                        ans[index] = 0;
                        ans[i + index] = 0;
                        visited[i] = false;
                    }
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
            Assert.assertEquals("[3, 1, 2, 3, 2]", Arrays.toString(solution.constructDistancedSequence(3)));
            Assert.assertEquals("[5, 3, 1, 4, 3, 5, 2, 4, 2]", Arrays.toString(solution.constructDistancedSequence(5)));
            Assert.assertEquals("[10, 8, 6, 9, 3, 1, 7, 3, 6, 8, 10, 5, 9, 7, 4, 2, 5, 2, 4]", Arrays.toString(solution.constructDistancedSequence(10)));
        }
    }
}