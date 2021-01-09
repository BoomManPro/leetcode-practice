package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest990 {
//给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!
//=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。 
//
// 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：["a==b","b!=a"]
//输出：false
//解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
// 
//
// 示例 2： 
//
// 输入：["b==a","a==b"]
//输出：true
//解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
// 
//
// 示例 3： 
//
// 输入：["a==b","b==c","a==c"]
//输出：true
// 
//
// 示例 4： 
//
// 输入：["a==b","b!=c","c==a"]
//输出：false
// 
//
// 示例 5： 
//
// 输入：["c==c","b==d","x!=z"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] 和 equations[i][3] 是小写字母 
// equations[i][1] 要么是 '='，要么是 '!' 
// equations[i][2] 是 '=' 
// 
// Related Topics 并查集 图 
// 👍 141 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean equationsPossible(String[] equations) {
            Map<Character, Integer> dict = new HashMap<>();
            int count = 0;
            for (String equation : equations) {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                if (!dict.containsKey(x)) {
                    dict.put(x, count++);
                }
                if (!dict.containsKey(y)) {
                    dict.put(y, count++);
                }
            }
            UnionFind unionFind = new UnionFind(count);
            for (String equation : equations) {
                if (equation.charAt(1) == '=') {
                    char x = equation.charAt(0);
                    char y = equation.charAt(3);
                    unionFind.union(dict.get(x), dict.get(y));
                }
            }

            for (String equation : equations) {
                if (equation.charAt(1) == '!') {
                    char x = equation.charAt(0);
                    char y = equation.charAt(3);
                    if (unionFind.find(dict.get(x)) == unionFind.find(dict.get(y))) {
                        return false;
                    }
                }
            }

            return true;

        }


        static final class UnionFind {
            int[] parents;

            public UnionFind(int n) {
                parents = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                }
            }

            public boolean union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px == py) {
                    return false;
                }
                if (px > py) {
                    int temp = py;
                    py = px;
                    px = temp;
                }
                parents[px] = py;
                return true;
            }

            private int find(int v) {
                if (v != parents[v]) {
                    parents[v] = find(parents[v]);
                }
                return parents[v];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertFalse(solution.equationsPossible(new String[]{"a==b", "b!=a"}));
            Assert.assertTrue(solution.equationsPossible(new String[]{"b==a", "a==b"}));
            Assert.assertTrue(solution.equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
            Assert.assertFalse(solution.equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
            Assert.assertTrue(solution.equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
        }
    }
}