package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SolutionTest207 {
//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1] 
//
// 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？ 
//
// 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 1 <= numCourses <= 10^5 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses];
            List<List<Integer>> adjacency = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++)
                adjacency.add(new ArrayList<>());
            // Get the in-degree and adjacency of every course.
            for (int[] cp : prerequisites) {
                inDegree[cp[0]]++;
                adjacency.get(cp[1]).add(cp[0]);
            }
            // Get all the courses with the in-degree of 0.
            for (int i = 0; i < numCourses; i++)
                if (inDegree[i] == 0) queue.add(i);
            // BFS TopSort.
            while (!queue.isEmpty()) {
                int pre = queue.poll();
                numCourses--;
                for (int cur : adjacency.get(pre))
                    if (--inDegree[cur] == 0) queue.add(cur);
            }
            return numCourses == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.canFinish(2, new int[][]{{1, 0}}));
            Assert.assertFalse(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        }
    }
}