//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划 
// 👍 471 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：不同路径 II
public class P63UniquePathsIi{
    public static void main(String[] args) {
        Solution solution = new P63UniquePathsIi().new Solution();
        // TO TEST
//        int[][] obstacleGrid = {{0,0,0,0},{0,1,0,1},{0,0,0,0},{1,0,0,0}};
        int[][] obstacleGrid = {{0,0},{0,1}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
        for (int i = 0; i <obstacleGrid.length ; i++) {
            System.out.println(Arrays.toString(obstacleGrid[i]));
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1){
            return 0;
        }
        for (int i = 0; i <obstacleGrid.length ; i++) {
            for (int j = 0; j <obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        obstacleGrid[0][0] = 1;
        for (int i = 0; i <obstacleGrid.length ; i++) {
            for (int j = 0; j <obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == -1 || (i==0&&j==0)) continue;
                int up = i - 1 < 0 || obstacleGrid[i-1][j] == -1 ? 0 : obstacleGrid[i-1][j];
                int left = j - 1 < 0 || obstacleGrid[i][j-1] == -1 ? 0 : obstacleGrid[i][j-1];
                obstacleGrid[i][j] = up + left;
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
解答成功: 执行耗时:1 ms,击败了17.81% 的Java用户 内存消耗:36.4 MB,击败了90.32% 的Java用户
第一次没有通过还是因为没考虑终点是障碍物的特殊情况。

2. 没有思路则直接看解法，比较解法优劣
3. 背诵和默写解法
第二遍
1. 马上自己写 -> LeeCode提交
2. 多种解法比较，体会 -> 优化
第三遍
1. 过了一天后重复练习相同题目
第四遍
1. 过了一周重复练习
第五遍
1. 面试前一周重复练习	
*/
}