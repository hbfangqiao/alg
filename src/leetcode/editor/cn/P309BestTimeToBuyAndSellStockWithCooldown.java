//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 663 👎 0


package leetcode.editor.cn;

//Java：最佳买卖股票时机含冷冻期
public class P309BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new P309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
        int[] input = {1,2,3,0,2};
//        System.out.println(solution.maxProfit(input));
        System.out.println(solution.maxProfit(new int[]{2,5,1,6,7}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0; //卖出状态
        dp[0][1] = -prices[0];//买入状态
        dp[0][2] = 0; //冷静期
        for (int i = 1; i <prices.length ; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][2] - prices[i],dp[i-1][1]);
            dp[i][2] = Math.max(dp[i-1][0],dp[i-1][2]);
        }
        return Math.max(dp[prices.length - 1][0],dp[prices.length - 1][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
我的思路：
定义状态，一共有三种状态：
a.卖出状态，处于非冷静期。
b.卖出状态，处于冷静期
c.买入状态
推导方程：
卖出非冷静 = max 卖出非冷静， 买入-> 卖出非冷静
买入状态 = max 买入状态，卖出冷静 -> 买入
卖出冷静期 = max 卖出冷静期， 卖出非冷静


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