package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest289 {
//根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。 
//
// 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞
//。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律： 
//
// 
// 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡； 
// 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活； 
// 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡； 
// 如果死细胞周围正好有三个活细胞，则该位置死细胞复活； 
// 
//
// 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死
//亡是同时发生的。 
//
// 示例: 
//
// 输入: 
//[
//  [0,1,0],
//  [0,0,1],
//  [1,1,1],
//  [0,0,0]
//]
//输出: 
//[
//  [0,0,0],
//  [1,0,1],
//  [0,1,1],
//  [0,1,0]
//] 
//
// 进阶: 
//
// 
// 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。 
// 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？ 
// 
// Related Topics 数组

    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void gameOfLife(int[][] board) {

            int width = board.length;
            int height = board[0].length;
            //状态移位
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    board[i][j] <<= 1;
                }
            }

            //设置状态
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    board[i][j] = getStatus(board, i, j);
                }
            }

            //状态处理
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    board[i][j] &= 1;
                }
            }

        }

        int[][] round = new int[][]{
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, 1},
                {0, -1},
                {1, 1},
                {1, 0},
                {1, -1},
        };

        public int getStatus(int[][] board, int i, int j) {
            int count = 0;
            int width = board.length;
            int height = board[0].length;
            //对其周围8个进行统计
            for (int[] around : round) {
                int x = around[0] + i;
                int y = around[1] + j;
                if (x >= 0 && x < width && y >= 0 && y < height) {
                    count += board[x][y] == 2 || board[x][y] == 3 ? 1 : 0;
                }
            }
            return board[i][j] >> 1 == 0 ? (count == 3 ? 1 : 0) : (count == 2 || count == 3 ? 3 : 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            int[][] init = {
                    {0, 1, 0},
                    {0, 0, 1},
                    {1, 1, 1},
                    {0, 0, 0},
            };
            solution.gameOfLife(init);
            Assert.assertArrayEquals(new int[][]{
                    {0, 0, 0},
                    {1, 0, 1},
                    {0, 1, 1},
                    {0, 1, 0},
            }, init);
        }
    }
}