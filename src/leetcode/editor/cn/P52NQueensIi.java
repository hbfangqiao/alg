//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 234 👎 0


package leetcode.editor.cn;

//Java：N皇后 II
public class P52NQueensIi {
    public static void main(String[] args) {
        Solution solution = new P52NQueensIi().new Solution();
        // TO TEST
        int totalNQueens = solution.totalNQueens(4);
        System.out.println(totalNQueens);
//        System.out.println(Integer.toBinaryString(1 << 4));
//        System.out.println(Integer.toBinaryString((1 << 4) - 1));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(-3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int size;
        private int count;


        public int totalNQueens(int n) {
            count = 0;
            size = (1 << n) - 1;// n=4  1111
            solve(0,0,0);// ld 撇 rd捺
            return count;
        }

        private void solve(int row,int ld,int rd){ // row 代表当前行 哪些位置被 纵向攻击到了。 ld 代表当前行哪些位置被左方攻击到。rd同理
            if (row == size){// n=4 时 row = 1111 意味着 4列上都有棋子了。即为解。
                count ++;
                return;
            }
            int pos = size & (~(row | ld | rd));//获取当前行没有被攻击到的位 (row | ld | rd) 所有占用的位 前面取反~ 就是所有没有被占用的位 & size 去掉高位的1
            while (pos!=0){//依次遍历每个没有被攻击到的位
                int p = pos & (-pos);//取最低位的1
                pos -= p;
                solve(row | p, (ld | p) << 1,(rd | p) >> 1);
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
*/
}