//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 459 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：有效的数独
public class P36ValidSudoku{
    public static void main(String[] args) {
        Solution solution = new P36ValidSudoku().new Solution();
        // TO TEST
        char[][] input = new char[][]{
                  new char[]{'5','3','.','.','7','.','.','.','.'},
                  new char[]{'6','.','.','1','9','5','.','.','.'},
                  new char[]{'.','9','8','.','.','.','.','6','.'},
                  new char[]{'8','.','.','.','6','.','.','.','3'},
                  new char[]{'4','.','.','8','.','3','.','.','1'},
                  new char[]{'7','.','.','.','2','.','.','.','6'},
                  new char[]{'.','6','.','.','.','.','2','8','.'},
                  new char[]{'.','.','.','4','1','9','.','.','5'},
                  new char[]{'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(input));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] columSets = new Set[9];
        Set<Character>[] boxSets = new Set[9];
        for (int i = 0; i <9 ; i++) {
            columSets[i] = new HashSet<>();
            boxSets[i] = new HashSet<>();
        }
        for (int i = 0; i <board.length ; i++) {
            Set<Character> rowSet = new HashSet<>();
            char[] row = board[i];
            for (int j = 0; j <row.length; j++) {
                Character c = row[j];
                if (c == '.') continue;
                if (rowSet.contains(c)) return false;
                rowSet.add(c);
                if (columSets[j].contains(c)) return false;
                columSets[j].add(c);
                if (boxSets[getBox(i,j)].contains(c)) return false;
                boxSets[getBox(i,j)].add(c);
            }
        }
        return true;
    }

    private Integer getBox(Integer i,Integer j){
        return (i / 3) * 3  + j / 3;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
我的思路：遍历一遍，遍历行时 使用map 记录访问过的元素。同时记录列和各个盒子访问过的元素。判断是否已经访问过
解答成功: 执行耗时:3 ms,击败了53.83% 的Java用户 内存消耗:38.9 MB,击败了16.88% 的Java用户

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