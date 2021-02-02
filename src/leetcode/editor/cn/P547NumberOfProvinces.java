//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 485 👎 0


package leetcode.editor.cn;

//Java：省份数量
public class P547NumberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new P547NumberOfProvinces().new Solution();
        // TO TEST
        int[][] input = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] input2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        System.out.println(solution.findCircleNum(input));
        System.out.println(solution.findCircleNum(input2));

        Solution.UnionFind unionFind = new P547NumberOfProvinces().new Solution().new UnionFind(10);
        unionFind.union(4,5);
        unionFind.union(1,4);
        unionFind.union(1,2);
        unionFind.union(1,5);
        System.out.println(unionFind.count);
        unionFind.find(4);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class UnionFind {
            private int count = 0;
            private int[] parent;

            public UnionFind(int n) {
                count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int p) {
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];//路径压缩
                    p = parent[p];
                }
                return p;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {
                    return;
                }
                parent[rootP] = rootQ;
                count--;
            }
        }

        public int findCircleNum(int[][] isConnected) {
            UnionFind unionFind = new UnionFind(isConnected.length);
            for (int i = 0; i <isConnected.length ; i++) {
                for (int j = 0; j <isConnected[0].length ; j++) {
                    if (isConnected[i][j] == 1){
                        unionFind.union(i,j);
                    }
                }
            }
            return unionFind.count;
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
*/
}