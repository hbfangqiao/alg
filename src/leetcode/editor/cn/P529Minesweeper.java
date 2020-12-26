//让我们一起来玩扫雷游戏！ 
//
// 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）
//地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。 
//
// 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板： 
//
// 
// 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。 
// 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。 
// 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。 
// 如果在此次点击中，若无更多方块可被揭露，则返回面板。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 示例 2： 
//
// 输入: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 
//
// 注意： 
//
// 
// 输入矩阵的宽和高的范围为 [1,50]。 
// 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。 
// 输入面板不会是游戏结束的状态（即有地雷已被挖出）。 
// 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 206 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：扫雷游戏
public class P529Minesweeper{
    public static void main(String[] args) {
        Solution solution = new P529Minesweeper().new Solution();
        // TO TEST
        char[][] board = new char[][]{
          new char[]{'E', 'E', 'E', 'E', 'E'},
          new char[]{'E', 'E', 'M', 'E', 'E'},
          new char[]{'E', 'E', 'E', 'E', 'E'},
          new char[]{'E', 'E', 'E', 'E', 'E'},
        };
        char[][] chars = solution.updateBoard(board, new int[]{1, 2});
        for (char[] line: chars){
            System.out.println(line);
        }
        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0] == null) {
            return board;
        }
        int row = click[0];
        int col = click[1];
        if ('M' == board[row][col]){
            board[row][col] = 'X';
            return board;
        }
        Set<String> visited = new HashSet<>();
        dfs(board,row,col,visited);
        return board;
    }

    private void dfs(char[][] board,int row,int col,Set<String> visited){
        if (!isInBoard(board, row, col) || isGrab(board,row,col) || isMine(board,row,col) || visited.contains(row+","+col)){
            return;
        }
        //查找最近的8个点
        int mCount = 0;
        if (isMine(board,row+1,col)) mCount++;
        if (isMine(board,row+1,col - 1)) mCount++;
        if (isMine(board,row+1,col + 1)) mCount++;
        if (isMine(board,row,col - 1)) mCount++;
        if (isMine(board,row,col + 1)) mCount++;
        if (isMine(board,row-1,col)) mCount++;
        if (isMine(board,row-1,col-1)) mCount++;
        if (isMine(board,row-1,col+1)) mCount++;
        visited.add(row+","+col);
        if (mCount == 0){//周围没有雷
            board[row][col] = 'B';
            dfs(board,row+1,col,visited);
            dfs(board,row+1,col-1,visited);
            dfs(board,row+1,col+1,visited);
            dfs(board,row,col-1,visited);
            dfs(board,row,col+1,visited);
            dfs(board,row-1,col,visited);
            dfs(board,row-1,col-1,visited);
            dfs(board,row-1,col+1,visited);
        }else {
            board[row][col] = (char) (mCount + 48);
        }
    }

    private boolean isMine(char[][] board, int row, int col){
        if (isInBoard(board,row,col)){
            return board[row][col] == 'M' || board[row][col] == 'X';
        }
        return false;
    }

    private boolean isGrab(char[][] board,int row,int col){
        if (isInBoard(board,row,col)){
            return board[row][col] == 'B' || (board[row][col]>= 1+48 && board[row][col] <= 8+48) || board[row][col] == 'X';
        }
        return false;
    }

    private boolean isInBoard(char[][] board,int row,int col){
        if (row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1){
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
我的思路
使用dfs 遍历。停止递归的条件为  1.不在扫雷区域内 2.该区域已经挖过了，3.该点是雷 4.已经遍判断过该点了
方法体为，获取周围的8个点，判断有几个雷。没有雷进行标记，进入下一层递归。有雷则标记数字，停止dfs
解答成功: 执行耗时:10 ms,击败了7.60% 的Java用户 内存消耗:40.3 MB,击败了5.08% 的Java用户

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