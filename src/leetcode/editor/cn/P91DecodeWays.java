//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A
//" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "
//6" 和 "06" 不同。 
//
// 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行
//解码，因为所有数字都需要映射。
// 
//
// 示例 4： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 不能映射到 "F" ，因为字符串开头的 0 无法指向一个有效的字符。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 632 👎 0


package leetcode.editor.cn;
//Java：解码方法
public class P91DecodeWays{
    public static void main(String[] args) {
        Solution solution = new P91DecodeWays().new Solution();
        String[] split = "1231".split("");

        // TO TEST
        System.out.println(solution.numDecodings("0"));//0
        System.out.println(solution.numDecodings("12"));//2
        System.out.println(solution.numDecodings("226"));//3 (2,2) (22)  -> (2,2,6) (22,6) (2,26)
        System.out.println(solution.numDecodings("206"));// 1 (2) -> () (20) -> (20,6) (2,06)
        System.out.println(solution.numDecodings("2020"));// 1
        System.out.println(solution.numDecodings("2030"));// 0
        System.out.println(solution.numDecodings("2101"));// 1 (2,1) (21) -> (2,10) (2,10)
        System.out.println(solution.numDecodings("10011"));//0
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")){
            return 0;
        }
        String[] stringArray = s.split("");
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i <stringArray.length ; i++) {
            String pre = stringArray[i-1];
            String current = stringArray[i];
            Integer num = Integer.parseInt(pre + current);
            if ("0".equals(current)){
                if (num <= 26 && num >= 1){
                    dp[i+1] = dp[i-1];//只能合并译码
                }else {
                    return 0;//无法译码
                }
            }else {
                if ((!"0".equals(pre)) && num <= 26){
                    dp[i+1] = dp[i] + dp[i-1];//分开译码+合并译码
                }else {
                    dp[i+1] = dp[i];//只能分开译码
                }
            }

        }
        return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
// xxx23  1<=23<=26  +1    xxx31   31 > 26  +0  (x,x,y) (x,xy) 思路错误。有问题。未解出来
2. 没有思路则直接看解法，比较解法优劣
https://leetcode-cn.com/problems/decode-ways/solution/c-wo-ren-wei-hen-jian-dan-zhi-guan-de-jie-fa-by-pr/

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