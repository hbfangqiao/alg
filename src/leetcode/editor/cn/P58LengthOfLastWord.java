//给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = " "
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// 
// Related Topics 字符串 
// 👍 299 👎 0


package leetcode.editor.cn;
//Java：最后一个单词的长度
public class P58LengthOfLastWord{
    public static void main(String[] args) {
        Solution solution = new P58LengthOfLastWord().new Solution();
        // TO TEST
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord(" "));
        System.out.println(solution.lengthOfLastWord("Hello  "));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int length = 0;
        for (int i = 0; i <chars.length ; i++) {
            char ch = chars[i];
            if (ch == ' ' && i < chars.length - 1 && chars[i+1] != ' '){//为空，并且后面有单词
                length = 0;
                continue;
            }
            if (ch == ' ' && i <chars.length - 1 && chars[i+1] == ' '){//为空格，并且后面也是空格
                continue;
            }
            if (ch == ' ' && i == chars.length -1 ){//为空，并且是最后一个
                continue;
            }
            length ++;
        }
        return length;
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