//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。 
//
// 
//
// 示例 1： 
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
// Related Topics 双指针 字符串 
// 👍 385 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：反转字符串
public class P344ReverseString{
    public static void main(String[] args) {
        Solution solution = new P344ReverseString().new Solution();
        // TO TEST
        char[] input = new char[]{'H','e','l','l','o'};
        solution.reverseString(input);
        System.out.println(Arrays.toString(input));

        char[] input2 = new char[]{'H'};
        solution.reverseString(input2);
        System.out.println(Arrays.toString(input2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0){
            return;
        }
        for (int i = 0; i <s.length ; i++) {
            if (i > s.length - 1 - i){
                break;
            }
            char tmp = s[i];
            s[i] = s[s.length - 1 -i];
            s[s.length - 1 - i] = tmp;
        }
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