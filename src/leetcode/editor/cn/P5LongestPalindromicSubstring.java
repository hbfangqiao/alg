//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3503 👎 0


package leetcode.editor.cn;
//Java：最长回文子串
public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("babad"));//bab
        System.out.println(solution.longestPalindrome("aabbaa"));//aabbaa
        System.out.println(solution.longestPalindrome("cbbd"));//bb
        System.out.println(solution.longestPalindrome("a"));//a
        System.out.println(solution.longestPalindrome("ac"));//a

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        return findPalindrome(s.length(),s);

    }

    private String findPalindrome(int length,String s){
        if (length == 1) return s.substring(0,1);
        for (int i = 0; i <= s.length() - length; i++) {
            if (isPalindrome(i,i+length - 1,s)){
                return s.substring(i,i+length);
            }
        }
        return findPalindrome(length - 1,s);
    }

    private boolean isPalindrome(int low,int high,String s){
        for (int i = low,j = high; i < j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
String s = "xxxxxxx"  先用 s.length 去 s中寻找回文串，再用 s.length - 1 去寻找回文串，找到即为最大值
时间复杂度O(N!)

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