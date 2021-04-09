//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 122 👎 0


package leetcode.editor.cn;

//Java：反转字符串 II
public class P541ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new P541ReverseStringIi().new Solution();
        // TO TEST
        System.out.println(solution.reverseStr("abcdefg", 2));//bacdfeg

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            int reversCount = 0;
            while ((reversCount) * 2 * k < chars.length) {
                int startIndex = reversCount * 2 * k;
                int endIndex = startIndex + k < chars.length ? startIndex + k - 1 : chars.length - 1;
                int reverseIndex = (endIndex - startIndex + 1) / 2 + startIndex;
                for (int i = startIndex; i < reverseIndex; i++) {
                    char tmp = chars[i];
                    chars[i] = chars[endIndex - (i - startIndex)];
                    chars[endIndex - (i - startIndex)] = tmp;
                }
                reversCount++;
            }
            return new String(chars);
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