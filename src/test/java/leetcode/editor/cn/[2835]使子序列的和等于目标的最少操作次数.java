package leetcode.editor.cn;

import com.sun.jndi.cosnaming.CNCtx;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest2835 {
//给你一个下标从 0 开始的数组 nums ，它包含 非负 整数，且全部为 2 的幂，同时给你一个整数 target 。
//
// 一次操作中，你必须对数组做以下修改：
//
//
// 选择数组中一个元素 nums[i] ，满足 nums[i] > 1 。
// 将 nums[i] 从数组中删除。
// 在 nums 的 末尾 添加 两个 数，值都为 nums[i] / 2 。
//
//
// 你的目标是让 nums 的一个 子序列 的元素和等于 target ，请你返回达成这一目标的 最少操作次数 。如果无法得到这样的子序列，请你返回 -1 。
//
//
// 数组中一个 子序列 是通过删除原数组中一些元素，并且不改变剩余元素顺序得到的剩余数组。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,8], target = 7
//输出：1
//解释：第一次操作中，我们选择元素 nums[2] 。数组变为 nums = [1,2,4,4] 。
//这时候，nums 包含子序列 [1,2,4] ，和为 7 。
//无法通过更少的操作得到和为 7 的子序列。
//
//
// 示例 2：
//
//
//输入：nums = [1,32,1,2], target = 12
//输出：2
//解释：第一次操作中，我们选择元素 nums[1] 。数组变为 nums = [1,1,2,16,16] 。
//第二次操作中，我们选择元素 nums[3] 。数组变为 nums = [1,1,2,16,8,8] 。
//这时候，nums 包含子序列 [1,1,2,8] ，和为 12 。
//无法通过更少的操作得到和为 12 的子序列。
//
// 示例 3：
//
//
//输入：nums = [1,32,1], target = 35
//输出：-1
//解释：无法得到和为 35 的子序列。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 2³⁰
// nums 只包含非负整数，且均为 2 的幂。
// 1 <= target < 2³¹
//
//
// 👍 6, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(List<Integer> nums, int target) {
            long sum = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (Integer num : nums) {
                if ((target & num) != 0) {
                    target ^= num;
                    continue;
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
                sum += num;
            }
            if (target == 0) {
                return 0;
            }
            if (sum < target) {
                return -1;
            }
            int ans = 0;
            String s = Integer.toBinaryString(target);
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
                int p = len - 1 - i;
                if (s.charAt(i) != '0') {
                    int v = (int) Math.pow(2, p);
                    for (int curr = 1; curr < v; curr *= 2) {
                        if (map.getOrDefault(curr, 0) != 0) {
                            Integer cnt = map.get(curr);
                            int next = curr * 2;
                            map.put(next, map.getOrDefault(next, 0) + (cnt / 2));
                            map.put(curr, cnt % 2);
                        }
                    }
                    if (map.getOrDefault(v, 0) != 0) {
                        map.put(v, map.get(v) - 1);
                        target ^= v;
                    } else {
                        //需要向上借
                        for (int curr = v * 2; ; curr *= 2) {
                            if (map.getOrDefault(curr, 0) != 0) {
                                for (int j = v; j < curr; j *= 2) {
                                    map.put(j, map.getOrDefault(j, 0) + 1);
                                }
                                map.put(curr, map.get(curr) - 1);
                                ans += log2(curr) - log2(v);
                                break;
                            }
                        }
                    }
                }
            }
            return ans;
        }

        double log2(double n) {
            return Math.log(n) / Math.log(2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.minOperations(Arrays.asList(1, 2, 8), 7));
            Assert.assertEquals(2, solution.minOperations(Arrays.asList(1, 32, 1, 2), 12));
            Assert.assertEquals(-1, solution.minOperations(Arrays.asList(1, 32, 1), 35));
            Assert.assertEquals(4, solution.minOperations(Arrays.asList(128, 1, 128, 1, 64), 4));
            Assert.assertEquals(2, solution.minOperations(Arrays.asList(8, 1024, 8388608, 4, 8, 2097152, 1024, 1024, 128, 1073741824, 4, 4096, 4, 4, 524288, 65536, 33554432, 2097152, 65536, 65536, 128, 4, 4, 8, 268435456, 256, 268435456, 65536, 33554432, 4096, 1073741824, 1073741824, 524288, 8388608, 33554432, 4096, 33554432, 1024, 1073741824, 4, 8, 2097152, 4), 43));
            Assert.assertEquals(2, solution.minOperations(Arrays.asList(1024, 16777216, 4194304, 131072, 4194304, 4096, 262144, 131072, 1073741824, 1048576, 512, 1073741824, 128, 4096, 2048, 32768, 128, 128, 262144, 16384, 2097152, 1073741824, 128, 1, 1073741824, 2097152, 32, 16777216, 1073741824, 4194304, 512, 4194304, 2048, 128, 1024, 1, 262144, 128, 8388608, 1048576, 262144, 65536, 8192, 1073741824, 4194304, 1024, 128, 1073741824, 512, 4096, 1, 4194304, 32768, 4194304, 4194304, 1073741824, 268435456, 1024, 262144, 2, 67108864, 8192, 1024, 128, 1073741824, 1048576, 8388608, 4194304, 8388608, 4, 128, 32768, 128, 512, 4096, 67108864, 1, 8388608, 128, 4096, 32768, 1073741824, 128, 32, 1048576, 16777216, 1048576, 262144, 4194304), 89));
        }

    }
}
