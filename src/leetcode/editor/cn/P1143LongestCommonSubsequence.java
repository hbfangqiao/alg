//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划 
// 👍 343 👎 0


package leetcode.editor.cn;

//Java：最长公共子序列
public class P1143LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new P1143LongestCommonSubsequence().new Solution();
        // TO TEST
        System.out.println(solution.longestCommonSubsequence("aacde", "ace"));//3

        System.out.println(solution.longestCommonSubsequence("abc","abc"));//3
        System.out.println(solution.longestCommonSubsequence("abc","def"));//0
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length() + 1;
            int n = text2.length() + 1;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1 ; j++) {
                    char c1 = text1.charAt(i);
                    char c2 = text2.charAt(j);
                    if (c1 == c2){
                        dp[i+1][j+1] = dp[i][j] + 1;
                    }else {
                        dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：√
1. 5-15分钟读题思考题目 √
2. 没有思路则直接看解法，比较解法优劣
3. 背诵和默写解法
第二遍 √
1. 马上自己写 -> LeeCode提交
2. 多种解法比较，体会 -> 优化
第三遍
1. 过了一天后重复练习相同题目
第四遍
1. 过了一周重复练习
第五遍
1. 面试前一周重复练习

题解第一遍
public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m+1][n+1];
    for (int i = 0; i <m ; i++) {
        for (int j = 0; j <n ; j++) {
            char c1 = text1.charAt(i);
            char c2 = text2.charAt(j);
            if (c1 == c2){
                dp[i+1][j+1] = dp[i][j] + 1;
            }else {
                dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
    }
    for (int i = 0; i <dp.length ; i++) {
        System.out.println(Arrays.toString(dp[i]));
    }
    return dp[m][n];
}
*/
}