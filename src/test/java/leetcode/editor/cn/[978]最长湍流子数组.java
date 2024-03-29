package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest978 {
//当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组： 
//
// 
// 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]； 
// 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。 
// 
//
// 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。 
//
// 返回 A 的最大湍流子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：[9,4,2,10,7,8,8,1,9]
//输出：5
//解释：(A[1] > A[2] < A[3] > A[4] < A[5])
// 
//
// 示例 2： 
//
// 输入：[4,8,12,16]
//输出：2
// 
//
// 示例 3： 
//
// 输入：[100]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 40000 
// 0 <= A[i] <= 10^9 
// 
// Related Topics 数组 动态规划 Sliding Window 
// 👍 52 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxTurbulenceSize(int[] A) {
            if (A.length <= 1) {
                return A.length;
            }
            int ans = 1;
            int[] status = new int[]{0, 1};
            for (int i = 1; i < A.length; i++) {
                if (A[i] == A[i - 1]) {
                    status[0] = 0;
                    status[1] = 1;
                } else if (A[i] > A[i - 1]) {
                    if (status[0] == 1) {
                        status[1] = 2;
                    } else {
                        status[0] = 1;
                        status[1]++;
                    }
                } else {
                    if (status[0] == -1) {
                        status[1] = 2;
                    } else {
                        status[0] = -1;
                        status[1]++;
                    }
                }
                ans = Math.max(ans, status[1]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(5, solution.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
            Assert.assertEquals(2, solution.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
            Assert.assertEquals(1, solution.maxTurbulenceSize(new int[]{100}));
        }
    }
}