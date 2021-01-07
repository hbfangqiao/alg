//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 278 👎 0


package leetcode.editor.cn;

//Java：验证回文串
public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // TO TEST
        boolean aba = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(aba);
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome("  "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() == 0){
                return true;
            }
            char[] chars = s.toCharArray();
            for (int i = 0,j=chars.length - 1; i <= j ;) {
                char left = chars[i];
                char right = chars[j];
                if (!isValid(left)){
                    i++;continue;
                }
                if (!isValid(right)){
                    j--;continue;
                }
                if (!String.valueOf(left).equalsIgnoreCase(String.valueOf(right))){
                    return false;
                }
                i++;j--;
            }
            return true;
        }

        private boolean isValid(char c){
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c<='Z') || (c >='0'&& c<='9');
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*
第一遍：
1. 5-15分钟读题思考题目 √
2. 没有思路则直接看解法，比较解法优劣 √
调用javaAPI
3. 背诵和默写解法 √
第二遍 √
1. 马上自己写 -> LeeCode提交
2. 多种解法比较，体会 -> 优化
第三遍
1. 过了一天后重复练习相同题目
使用双指针往中间移动的解法

第四遍
1. 过了一周重复练习
第五遍
1. 面试前一周重复练习

javaAPI解法：
public boolean isPalindrome(String s) {
    s = filterNotLetterAndNumber(s);
    return s.equalsIgnoreCase(reverseString(s));
}

private String reverseString(String s) {
    return new StringBuilder(s).reverse().toString();
}

private String filterNotLetterAndNumber(String s) {
    return s.replaceAll("[^0-9a-zA-Z]","");

}
*/