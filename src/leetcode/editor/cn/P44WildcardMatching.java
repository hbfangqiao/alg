//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心算法 字符串 动态规划 回溯算法 
// 👍 665 👎 0


package leetcode.editor.cn;
//Java：通配符匹配
public class P44WildcardMatching{
    public static void main(String[] args) {
        Solution solution = new P44WildcardMatching().new Solution();
        // TO TEST
        System.out.println(solution.isMatch("aa","a"));//false
        System.out.println(solution.isMatch("aa","*"));//true
        System.out.println(solution.isMatch("cb","?a"));//false
        System.out.println(solution.isMatch("adceb","*a*b"));//true
        System.out.println(solution.isMatch("acdcb","a*c?b"));//false
        System.out.println(solution.isMatch("aa","a*"));//true
        System.out.println(solution.isMatch("abcabczzzde","*abc???de*"));//true



    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length()+1;
        int n = p.length()+1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 0; i <n-1 ; i++) {
            if (p.charAt(i) == '*'){
                dp[0][i+1] = dp[0][i];
            }
        }
        for (int i = 0; i <m-1 ; i++) {
            for (int j = 0; j <n-1 ; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*'){
                    dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  //
/*
第一遍：
1. 5-15分钟读题思考题目 √
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

我的题解 O(n*n*m )
public boolean isMatch(String s, String p) {
    int m = s.length()+1;
    int n = p.length()+1;
    boolean[][] dp = new boolean[m][n];
    dp[0][0] = true;
    for (int i = 0; i <n-1 ; i++) {
        if (p.charAt(i) == '*'){
            dp[0][i+1] = dp[0][i];
        }
    }
    for (int i = 0; i <m-1 ; i++) {
        for (int j = 0; j <n-1 ; j++) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == '*'){
                for (int k = 0; k <=i+1 ; k++) {
                    if (dp[k][j]){
                        dp[i+1][j+1] = true;
                        break;
                    }
                }
            }
        }
    }
    return dp[m-1][n-1];
}

题解dp解法
public boolean isMatch(String s, String p) {
    int m = s.length()+1;
    int n = p.length()+1;
    boolean[][] dp = new boolean[m][n];
    dp[0][0] = true;
    for (int i = 0; i <n-1 ; i++) {
        if (p.charAt(i) == '*'){
            dp[0][i+1] = dp[0][i];
        }
    }
    for (int i = 0; i <m-1 ; i++) {
        for (int j = 0; j <n-1 ; j++) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == '*'){
                dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
            }
        }
    }
    return dp[m-1][n-1];
}
*/
}