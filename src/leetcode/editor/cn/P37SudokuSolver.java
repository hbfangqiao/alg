//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 727 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：解数独
public class P37SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new P37SudokuSolver().new Solution();
        // TO TEST
        char[][] input = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.solveSudoku(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Character>[] columSets = new Set[9];
        Set<Character>[] rowSets = new Set[9];
        Set<Character>[] boxSets = new Set[9];

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                columSets[i] = new HashSet<>();
                rowSets[i] = new HashSet<>();
                boxSets[i] = new HashSet<>();
            }
            for (int i = 0; i <board.length ; i++) {
                for (int j = 0; j <board[i].length ; j++) {
                    if (board[i][j] != '.'){
                        rowSets[i].add(board[i][j]);
                        columSets[j].add(board[i][j]);
                        boxSets[getBox(i,j)].add(board[i][j]);
                    }
                }
            }
            dfs(board,0);
        }

        private boolean dfs(char[][] board, Integer level) {
            if (level == 81){
                return true;
            }
            int row = level / 9;
            int colum = level % 9;
            if (board[row][colum] != '.'){
                return dfs(board,level+1);
            }
            for (char c = '1'; c <='9' ; c++) {
                if (columSets[colum].contains(c) || rowSets[row].contains(c) || boxSets[getBox(row, colum)].contains(c)){
                    continue;
                }
                board[row][colum] = c;
                columSets[colum].add(c);
                rowSets[row].add(c);
                boxSets[getBox(row,colum)].add(c);
                if (dfs(board,level+1)){
                    return true;
                }
                board[row][colum] = '.';
                columSets[colum].remove(c);
                rowSets[row].remove(c);
                boxSets[getBox(row,colum)].remove(c);
            }
            return false;

        }

        private Integer getBox(Integer row, Integer colum) {
            return (row / 3) * 3 + colum / 3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
使用 dfs，一共81层深度。 剪枝条件为，不符合数独规则的数字。
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