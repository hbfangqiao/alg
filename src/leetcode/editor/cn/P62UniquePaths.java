//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划 
// 👍 850 👎 0


package leetcode.editor.cn;

//Java：不同路径
public class P62UniquePaths {
    public static void main(String[] args) {
        Solution solution = new P62UniquePaths().new Solution();
        // TO TEST
        System.out.println(solution.uniquePaths(1, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int count = 0;

        public int uniquePaths(int m, int n) {
            dfs(1,1,m,n);
            return count;
        }

        private void dfs(int cX,int cY,int m,int n){
            if (cX == m && cY == n){
                count++;
                return;
            }
            if (cX+1 <= m){
                dfs(cX+1,cY,m,n);
            }
            if (cY+1 <= n){
                dfs(cX,cY+1,m,n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
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

我的解法：dfs 超时
    class Solution {

        private int count = 0;

        public int uniquePaths(int m, int n) {
            dfs(1,1,m,n);
            return count;
        }

        private void dfs(int cX,int cY,int m,int n){
            if (cX == m && cY == n){
                count++;
                return;
            }
            if (cX+1 <= m){
                dfs(cX+1,cY,m,n);
            }
            if (cY+1 <= n){
                dfs(cX,cY+1,m,n);
            }
        }
    }
*/
}