//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 2053 👎 0


package leetcode.editor.cn;

//Java：正则表达式匹配
public class P10RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new P10RegularExpressionMatching().new Solution();
        // TO TEST
        System.out.println(solution.isMatch("aa", "a"));//false
        System.out.println(solution.isMatch("aa", "a*"));//true
        System.out.println(solution.isMatch("ab", ".*"));//true
        System.out.println(solution.isMatch("aab", "c*a*b"));//true
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));//false
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length() + 1;
            int n = p.length() + 1;
            boolean[][] dp = new boolean[m][n];
            dp[0][0] = true;
            for (int i = 2; i < n; i+= 2) {// a*a*a* 可以和空串匹配
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = dp[0][i - 2];
                }
            }
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                        dp[i+1][j+1] = dp[i][j];
                    }
                    if (p.charAt(j) == '*'){
                        if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j-1) != '.'){
                            dp[i+1][j+1] = dp[i+1][j-1];//前一个不等且不为.  ab  abc* 这种情况
                        } else {//前一个相等
                            dp[i+1][j+1] = dp[i+1][j] // 去掉p的 * 进行比较  把 b* 当一个b 比较 ###b ###b* -> ###b ###b  把b*当 b
                                    || dp[i][j+1] // 去掉s最后一位去比较  ###b ###b*  ->  ###  ###b*  也是把 b*当empty
                                    || dp[i+1][j-1]; // 去掉 b* ###b  ###b* -> ###b ###  把 b* 当成empty
                        }
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
2. 没有思路则直接看解法，比较解法优劣
https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/
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