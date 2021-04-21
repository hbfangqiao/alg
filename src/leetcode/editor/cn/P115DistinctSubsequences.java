//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。 
//
// 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//(上箭头符号 ^ 表示选取的字母)
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 314 👎 0


package leetcode.editor.cn;
//Java：不同的子序列
public class P115DistinctSubsequences{
    public static void main(String[] args) {
        Solution solution = new P115DistinctSubsequences().new Solution();
        // TO TEST
        System.out.println(solution.numDistinct("babgbag","bagb"));
        System.out.println(solution.numDistinct("",""));
        System.out.println(solution.numDistinct("a",""));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length()+1;
        int n = t.length()+1;
        int[][] dp = new int[m][n];
        for (int i = 0; i <m ; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <m-1 ; i++) {
            for (int j = 0; j <n-1 ; j++) {
                if (s.charAt(i) == t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+dp[i][j+1];
                }else {
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
两个字符串问题，首先上来列二维dp[][]
但是未能推导出dp方程
2. 没有思路则直接看解法，比较解法优劣
https://leetcode-cn.com/problems/distinct-subsequences/solution/pythonti-jie-yi-kan-jiu-dong-de-fen-xi-yao-yao-yao/
dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
dp[i][j] = dp[i-1][j];

解释:  babgbag  bagb
S/T		b	a	g	b
	1	0	0	0	0
b	1	1	0	0	0
a	1	1	1	0	0
b	1	2	1	0	0
g	1	2	1	1	0
b	1	3	1	1	1
a	1	3	4	1	1
g	1	3	4	5	1

当 babgbag  bag  最后一位g相同，所以 dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
当babgbag 使用最后一位g的时候，那么就需要 看 ba 在 babgba里面有多少个不同的子序列.
当babgbag不使用最后一位g的时候 就要看 bag 在 babgba中有多少个不同的子序列

当 babgbag  bagb 最后一位不相同时, dp[i][j] = dp[i-1][j];
只需要看 bagb 在 bababag中有多少个不同的子序列.
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

第一遍:
public int numDistinct(String s, String t) {
    int col = t.length() + 1;
    int row = s.length() + 1;
    int[][] dp = new int[row][col];
    for (int i = 0; i <row ; i++) {
        dp[i][0] = 1;
    }
    for (int i = 1; i <row ; i++) {
        for (int j = 1; j <col ; j++) {
            if (s.charAt(i-1) == t.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    return dp[row-1][col-1];
}

第二遍
####b
###b  dp[i+1][j+1] = dp[i][j] + dp[i][j+1]

####b dp[i+1][j+1] = dp[i][j+1]
###c

public int numDistinct(String s, String t) {
    int m = s.length()+1;
    int n = t.length()+1;
    int[][] dp = new int[m][n];
    for (int i = 0; i <m ; i++) {
        dp[i][0] = 1;
    }
    for (int i = 0; i <m-1 ; i++) {
        for (int j = 0; j <n-1 ; j++) {
            if (s.charAt(i) == t.charAt(j)){
                dp[i+1][j+1] = dp[i][j]+dp[i][j+1];
            }else {
                dp[i+1][j+1] = dp[i][j+1];
            }
        }
    }
    return dp[m-1][n-1];
}
*/
}