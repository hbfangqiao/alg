//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1199 👎 0


package leetcode.editor.cn;
//Java：最长有效括号
public class P32LongestValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();
        // TO TEST
        System.out.println(solution.longestValidParentheses(")()))"));//2
        System.out.println(solution.longestValidParentheses(")()())"));//4
        System.out.println(solution.longestValidParentheses("((()))"));//6
        System.out.println(solution.longestValidParentheses("(()())"));//6
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int longestValidParentheses(String s) {
            int max = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i <s.length() ; i++) {
                if (s.charAt(i) == ')'){
                    if (s.charAt(i - 1) == '('){
                        dp[i] = i-2 >= 0 ? dp[i-2] + 2 : 2;
                    } else if ((i - dp[i-1] - 1) >= 0 &&(s.charAt(i - dp[i-1] - 1) == '(')){
                        dp[i] = dp[i-1] + 2 + ( (i - dp[i-1] - 2) >= 0 ? dp[i - dp[i-1] - 2] : 0);
                    }
                }
                max = Math.max(max,dp[i]);
            }
            return max;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
2. 没有思路则直接看解法，比较解法优劣
DP 解法
https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/

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