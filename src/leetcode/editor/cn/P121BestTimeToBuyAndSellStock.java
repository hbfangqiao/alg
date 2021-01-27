//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1406 👎 0


package leetcode.editor.cn;
//Java：买卖股票的最佳时机
public class P121BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
//        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
//        System.out.println(solution.maxProfit(new int[]{2,4,1,9}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;//第一次卖出
        dp[0][1] = -prices[0];//第一次买入
        for (int i = 1; i <prices.length ; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
未想出DP解法，遍历数组，记录最小的值，将当前值与最小值相减即为盈利，存储最大的盈利值 O(N)
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


思路一: 一次遍历
public int maxProfit(int[] prices) {
    if (prices.length == 0 || prices.length == 1){
        return 0;
    }
    int minPrice = prices[0];
    int result = 0;
    for (int i = 0; i <prices.length ; i++) {
        minPrice = Math.min(prices[i],minPrice);
        result = Math.max(result,prices[i] - minPrice);
    }
    return result;
}

思路二: DP
*/
}