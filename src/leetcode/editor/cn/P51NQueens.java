//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 707 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Java：N 皇后
public class P51NQueens {
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        // TO TEST
        List<List<String>> lists = solution.solveNQueens(5);
        lists.forEach(e -> {
            e.forEach(l->{
                System.out.println(l);
            });
            System.out.println("-----");
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<Integer>> results = new ArrayList<>();
            dfs(n,0,new ArrayList<>(),results);
            return results.stream().map(this::print).collect(Collectors.toList());
        }

        private void dfs(int n, int row, List<Integer> targetCols, List<List<Integer>> result) {
            if (row >= n) {
                result.add(new ArrayList<>(targetCols));
                return;
            }
            for (int col = 0; col < n; col++) {
                if (!isValid(targetCols,col,row)){
                    continue;
                }
                targetCols.add(col);
                dfs(n,row+1,targetCols,result);
                targetCols.remove(targetCols.size() -1);
            }
        }

        private boolean isValid(List<Integer> path,Integer col,Integer row){
            if (path.contains(col)){//在同一列
                return false;
            }
            for (int pRow = 0; pRow <path.size() ; pRow++) {
                Integer pCol = path.get(pRow);
                Integer colDistance = col - pCol;
                Integer rowDistance = row - pRow;
                if (colDistance.equals(rowDistance) || colDistance.equals(-rowDistance)){//在斜对角线上
                    return false;
                }
            }
            return true;
        }

        private List<String> print(List<Integer> result) {
            Integer n = result.size();
            List<String> strList = new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                StringBuilder builder = new StringBuilder();
                Integer col = result.get(i);
                for (int j = 0; j < n; j++) {
                    if (j!=col) {
                        builder.append(".");
                    }else {
                        builder.append("Q");
                    }
                }
                strList.add(builder.toString());
            }
            return strList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
我的思路：采用回溯算法。主要是判断 什么时候当前落的点是有效的。
使用一个 List 来存放之前每一层的 col 值。那么list的下标其实就是其所对应的 row值。
递归的当前层level 就是 当前的row值。使用这些即可去判断是否存在于一条斜线上了

解答成功: 执行耗时:9 ms,击败了17.58% 的Java用户 内存消耗:38.6 MB,击败了77.88% 的Java用户

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