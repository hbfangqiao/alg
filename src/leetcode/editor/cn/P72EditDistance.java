//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1424 👎 0


package leetcode.editor.cn;
//Java：编辑距离
public class P72EditDistance{
    public static void main(String[] args) {
        Solution solution = new P72EditDistance().new Solution();
        // TO TEST
        System.out.println(solution.minDistance("horse","ros"));//3
        System.out.println(solution.minDistance("intention","execution"));//5
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length()+1;
        int n = word2.length()+1;
        int dp[][] = new int[m][n];
        for (int i = 0; i <m ; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <n ; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <m-1 ; i++) {
            for (int j = 0; j <n-1 ; j++) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
                if (c1 == c2){
                    dp[i+1][j+1] = dp[i][j];
                }else {
                    dp[i+1][j+1] = Math.min(dp[i][j]+1,Math.min(dp[i][j+1] + 1,dp[i+1][j] + 1));
                }
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：√
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

第一遍

public int minDistance(String word1, String word2) {
    char[] charArray1 = word1.toCharArray();
    char[] charArray2 = word2.toCharArray();
    int[][] dp = new int[charArray1.length + 1][charArray2.length + 1];
    for (int i = 0; i <=charArray1.length ; i++) {
        dp[i][0] = i;
    }
    for (int i = 0; i <=charArray2.length ; i++) {
        dp[0][i] = i;
    }
    for (int i = 1; i <=charArray1.length ; i++) {
        for (int j = 1; j <=charArray2.length ; j++) {
            if (charArray1[i-1] == charArray2[j-1]){
                dp[i][j] = dp[i-1][j-1];
            }else {
                dp[i][j] = Math.min((dp[i-1][j-1] + 1),Math.min(dp[i-1][j] + 1,dp[i][j-1] + 1));
            }
        }
    }
    return dp[dp.length - 1][dp[0].length - 1];
}
*/
}