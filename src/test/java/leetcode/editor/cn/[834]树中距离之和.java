package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest834 {
//给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。 
//
// 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。 
//
// 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。 
//
// 示例 1: 
//
// 
//输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
//输出: [8,12,6,10,10,10]
//解释: 
//如下为给定的树的示意图：
//  0
// / \
//1   2
//   /|\
//  3 4 5
//
//我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5) 
//也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
// 
//
// 说明: 1 <= N <= 10000 
// Related Topics 树 深度优先搜索 
// 👍 114 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] ans;

        int[] sz;

        int[] dp;

        List<List<Integer>> graph;

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            ans = new int[N];
            sz = new int[N];
            dp = new int[N];
            graph = new ArrayList<List<Integer>>();
            for (int i = 0; i < N; ++i) {
                graph.add(new ArrayList<Integer>());
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            dfs(0, -1);
            dfs2(0, -1);
            return ans;
        }

        public void dfs(int u, int f) {
            sz[u] = 1;
            dp[u] = 0;
            for (int v : graph.get(u)) {
                if (v == f) {
                    continue;
                }
                dfs(v, u);
                dp[u] += dp[v] + sz[v];
                sz[u] += sz[v];
            }
        }

        public void dfs2(int u, int f) {
            ans[u] = dp[u];
            for (int v : graph.get(u)) {
                if (v == f) {
                    continue;
                }
                int pu = dp[u], pv = dp[v];
                int su = sz[u], sv = sz[v];

                dp[u] -= dp[v] + sz[v];
                sz[u] -= sz[v];
                dp[v] += dp[u] + sz[u];
                sz[v] += sz[u];

                dfs2(v, u);

                dp[u] = pu;
                dp[v] = pv;
                sz[u] = su;
                sz[v] = sv;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[8, 12, 6, 10, 10, 10]", Arrays.toString(solution.sumOfDistancesInTree(6,new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}})));
        }
    }
}