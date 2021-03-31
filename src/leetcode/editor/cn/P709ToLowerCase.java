//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串 
// 👍 145 👎 0


package leetcode.editor.cn;
//Java：转换成小写字母
public class P709ToLowerCase{
    public static void main(String[] args) {
        Solution solution = new P709ToLowerCase().new Solution();
        // TO TEST
        System.out.println(solution.toLowerCase("LOVELY"));
        System.out.println(solution.toLowerCase(""));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toLowerCase(String str) {
        char[] chs = str.toCharArray();
        int sub = 'A' - 'a';
        for (int i = 0; i <chs.length ; i++) {
            char ch = chs[i];
            if (ch >= 'A' && ch <= 'Z'){
                chs[i] = (char) (ch - sub);
            }
        }
        return String.valueOf(chs);
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