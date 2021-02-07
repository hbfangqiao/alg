//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 466 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：被围绕的区域
public class P130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
        // TO TEST
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','X','X'},
                {'X','X','O','X'},
                {'X','O','O','X'},
                {'X','O','X','X'}
        };
        solution.solve(board);
        solution.solve(new char[][]{});
        for(char[] row : board){
            System.out.println(Arrays.toString(row));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class UnionFind {
            private int[] parent;

            public UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int p) {
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP != rootQ) {
                    parent[rootP] = rootQ;
                }
            }

            public boolean isConnected(int p, int q) {
                return find(p) == find(q);
            }
        }

        public void solve(char[][] board) {
            if (board == null || board.length == 0){
                return;
            }
            int row = board.length;
            int col = board[0].length;
            final char CHAR_O = 'O';
            char CHAR_X = 'X';
            UnionFind unionFind = new UnionFind(row * col + 1);// +1 是存储一个虚拟节点
            int dummyNode = row * col;
            for (int i = 0; i <row ; i++) {
                for (int j = 0; j <col ; j++) {
                    if (board[i][j] == CHAR_O){
                        int cNode = i*col + j;
                        if (i == 0 || j == 0 || i == row - 1 || j == col -1 ){//在边界上
                            unionFind.union(cNode,dummyNode);
                        }else {
                            if(i > 0 && board[i-1][j] == CHAR_O){
                                unionFind.union(cNode,(i-1)*col + j);
                            }
                            if (i < row-1 && board[i+1][j] == CHAR_O){
                                unionFind.union(cNode,(i+1)*col + j);
                            }
                            if (j>0 && board[i][j-1] == CHAR_O){
                                unionFind.union(cNode,i*col + j -1 );
                            }
                            if (j < col -1 && board[i][j+1] == CHAR_O){
                                unionFind.union(cNode,i*col + j + 1);
                            }
                        }
                    }
                }
            }

            for (int i = 0; i <row ; i++) {
                for (int j = 0; j <col ; j++) {
                    if (board[i][j] == CHAR_O && !unionFind.isConnected(i*col + j,dummyNode)){
                        board[i][j] = CHAR_X;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √ 没有并查集思路
2. 没有思路则直接看解法，比较解法优劣 √
并查集思路：将O的联通区域分为与边界相连的区域和不与边界联通的区域。
与边界联通的区域统一与一个虚拟的点进行连接。
再进行一次遍历，如果是与边界相连的区域就不进行替换。

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