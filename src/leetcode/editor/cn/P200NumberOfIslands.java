//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 913 👎 0


package leetcode.editor.cn;

//Java：岛屿数量
public class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
        char[][] grid = new char[][]{
                new char[]{'1','1','1','1','0'},
                new char[]{'1','1','0','0','0'},
                new char[]{'1','1','0','1','0'},
                new char[]{'0','0','0','0','1'}
        };
//        char[][] grid = new char[][]{
//                new char[]{'1', '0', '1'},
//                new char[]{'1', '1', '1'},
//                new char[]{'1', '0', '1'},
//        };
        int i = solution.numIslands(grid);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class UnionFind{
            private int[] parent;
            private int count;

            public UnionFind(char[][] grid) {
                int row = grid.length;
                int col = grid[0].length;
                int length = row * col;
                parent = new int[length];
                for (int i = 0; i <row ; i++) {
                    for (int j = 0; j <col ; j++) {
                        int num = i * col + j;
                        if (grid[i][j] == '1'){
                            parent[num] = num;
                            count++;
                        }
                    }
                }
            }

            public int find(int p){
                if (p == parent[p]){
                    return p;
                }
                return find(parent[p]);
            }

            public void union(int p,int q){
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ){
                    return;
                }
                parent[rootQ] = rootP;
                count --;
            }


        }

        public int numIslands(char[][] grid) {
            UnionFind unionFind = new UnionFind(grid);
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};
            int row = grid.length;
            int col = grid[0].length;
            for (int i = 0; i <row ; i++) {
                for (int j = 0; j <col ; j++) {
                    if (grid[i][j] == '1'){
                        grid[i][j] = '0';
                        for (int k = 0; k <4 ; k++) {
                            int nextX = i+dx[k];
                            int nextY = j+dy[k];
                            if ((nextX >= 0 && nextX < row) && (nextY >= 0 && nextY < col) && grid[nextX][nextY] == '1'){
                                unionFind.union(i*col+j,nextX*col+nextY);
                            }
                        }
                    }
                }
            }
            return unionFind.count;

        }



    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √ 没有思路
2. 没有思路则直接看解法，比较解法优劣
a.使用dfs，将碰到的1相关联的1 全部变为0，看总共执行了几次
时间复杂度O(MN)
b 使用并查集，将每一个为1的数先作为单独的一个集合。遍历每个树所有的 4联通
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

我的DFS解:
public int numIslands(char[][] grid) {
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
        char[] line = grid[i];
        for (int j = 0; j < line.length; j++) {
            char c = line[j];
            if (c == '1') {
                dfs(i, j, grid);
                result++;
            }
        }
    }
    return result;
}

private void dfs(int i, int j, char[][] grid) {
    if (i == grid.length || j == grid[0].length || i < 0 || j < 0 || grid[i][j] == '0') {
        return;
    }
    grid[i][j] = '0';
    dfs(i + 1, j, grid);
    dfs(i - 1, j, grid);
    dfs(i, j + 1, grid);
    dfs(i, j - 1, grid);
}

*/
}