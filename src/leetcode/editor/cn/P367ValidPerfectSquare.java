//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 184 👎 0


package leetcode.editor.cn;
//Java：有效的完全平方数
public class P367ValidPerfectSquare{
    public static void main(String[] args) {
        Solution solution = new P367ValidPerfectSquare().new Solution();
        // TO TEST
//        System.out.println(solution.isPerfectSquare(1));
//        System.out.println(solution.isPerfectSquare(2));
//        System.out.println(solution.isPerfectSquare(3));
//        System.out.println(solution.isPerfectSquare(4));
//        System.out.println(solution.isPerfectSquare(5));
        System.out.println(solution.isPerfectSquare(6));
//        System.out.println(solution.isPerfectSquare(2147483647));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1,right = num,mid;
        while (left <= right){
            mid = left + (right - left)/2;
            if (mid * mid == num){
                return true;
            }else if(mid * mid > num){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
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