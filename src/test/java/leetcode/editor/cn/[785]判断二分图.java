package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest785 {
//给定一个无向图graph，当这个图为二分图时返回true。 
//
// 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。 
//
// graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自
//环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。 
//
// 
//
//示例 1:
//输入: [[1,3], [0,2], [1,3], [0,2]]
//输出: true
//解释: 
//无向图如下:
//0----1
//|    |
//|    |
//3----2
//我们可以将节点分成两组: {0, 2} 和 {1, 3}。
// 
//
// 
//
//示例 2:
//输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
//输出: false
//解释: 
//无向图如下:
//0----1
//| \  |
//|  \ |
//3----2
//我们不能将节点分割成两个独立的子集。
// 
//
// 注意: 
//
// 
// graph 的长度范围为 [1, 100]。 
// graph[i] 中的元素的范围为 [0, graph.length - 1]。 
// graph[i] 不会包含 i 或者有重复的值。 
// 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 
// 👍 90 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int UNCOLORED = 0;

        private static final int RED = 1;

        private static final int GREEN = 2;

        private int[] color;

        private boolean valid;

        public boolean isBipartite(int[][] graph) {
            if (graph == null || graph.length == 0) {
                return false;
            }
            int n = graph.length;
            int[] color = new int[n];
            valid = true;
            for (int i = 0; i < n; i++) {
                if (color[i] == UNCOLORED) {
                    dfs(i, RED, graph,color);
                }
            }
            return valid;
        }

        public void dfs(int node, int c, int[][] graph,int[] color) {
            color[node] = c;
            int neiColor = c == RED ? GREEN : RED;
            for (int nei : graph[node]) {
                if (color[nei] == UNCOLORED) {
                    dfs(nei, neiColor, graph, color);
                    if (!valid) {
                        return;
                    }
                } else if (color[nei] != neiColor) {
                    valid = false;
                    return;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
            Assert.assertFalse(solution.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        }
    }
}