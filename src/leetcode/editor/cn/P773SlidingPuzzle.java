//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示. 
//
// 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 示例： 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//输入：board = [[3,2,4],[1,5,0]]
//输出：14
// 
//
// 提示： 
//
// 
// board 是一个如上所述的 2 x 3 的数组. 
// board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列. 
// 
// Related Topics 广度优先搜索 
// 👍 109 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：滑动谜题
public class P773SlidingPuzzle {
    public static void main(String[] args) {
        Solution solution = new P773SlidingPuzzle().new Solution();
        // TO TEST
//        int[][] board = {{4,1,2},{5,0,3}};
//        int[][] board = {{1, 2, 3}, {4, 5, 0}};
        int[][] board = {{0, 5, 2}, {1, 3, 4}};
        long now = System.currentTimeMillis();
        System.out.println(solution.slidingPuzzle(board));
        System.out.println(System.currentTimeMillis() - now);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] moves = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {5, 3, 1}, {2, 4}};
        private Integer minStep = Integer.MAX_VALUE;
        private Map<String,Integer> canReachMinStep = new HashMap<>();

        public int slidingPuzzle(int[][] board) {

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < board.length; i++) {
                int[] boardRow = board[i];
                for (int j = 0; j < boardRow.length; j++) {
                    builder.append(boardRow[j]);
                }
            }
            if ("123450".equals(builder.toString())) {
                return 0;
            }
            List<String> path = new ArrayList<>();
            path.add(builder.toString());
            dfs(builder.toString(),path);
            canReachMinStep.put(board.toString(),0);
            return minStep == Integer.MAX_VALUE ? -1 : minStep;
        }

        private void dfs(String board, List<String> path) {
            if ("123450".equals(board)) {
                minStep = Math.min(path.size() - 1,minStep);
                return;
            }
            Integer zeroIndex = board.indexOf('0');
            for(int move : moves[zeroIndex]){
                char[] chars = board.toCharArray();
                chars[zeroIndex] = chars[move];
                chars[move] = '0';
                String newBoard = String.valueOf(chars);
                Integer minStep = canReachMinStep.get(newBoard);
                if (minStep != null && minStep <= path.size() - 1){
                    continue;
                }
                path.add(newBoard);
                canReachMinStep.put(newBoard,path.size() - 1);
                dfs(newBoard,path);
                path.remove(newBoard);
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
我的思路：BFS
解答成功:
执行耗时:6 ms,击败了93.20% 的Java用户
内存消耗:38 MB,击败了46.12% 的Java用户
第一次解答失败因为 未考虑初始就是答案的情况

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

我的解法：BFS
public int slidingPuzzle(int[][] board) {
    int[][] moves = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i <board.length ; i++) {
        int[] boardRow = board[i];
        for (int j = 0; j <boardRow.length ; j++) {
            builder.append(boardRow[j]);
        }
    }
    if ("123450".equals(builder.toString())){
        return 0;
    }
    Queue<String> queue = new LinkedList<>();
    queue.offer(builder.toString());
    Set<String> visited = new HashSet<>();
    visited.add(builder.toString());
    int step = 0;
    while (!queue.isEmpty()){
        int n = queue.size();
        for (int i = 0; i <n ; i++) {
            String boardString = queue.poll();
            int zeroIndex = boardString.indexOf('0');
            for (int move : moves[zeroIndex]){
                char[] chars = boardString.toCharArray();
                chars[zeroIndex] = chars[move];
                chars[move] = '0';
                String newBoardString = String.valueOf(chars);
                if ("123450".equals(newBoardString)){
                    return step + 1;
                }
                if (!visited.contains(newBoardString)){
                    visited.add(newBoardString);
                    queue.offer(newBoardString);
                }
            }
        }
        step ++;
    }
    return -1;
}

*/
}