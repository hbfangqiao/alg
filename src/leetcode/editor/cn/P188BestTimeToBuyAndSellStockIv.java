//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 100 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 432 👎 0


package leetcode.editor.cn;
//Java：买卖股票的最佳时机 IV
public class P188BestTimeToBuyAndSellStockIv{
    public static void main(String[] args) {
        Solution solution = new P188BestTimeToBuyAndSellStockIv().new Solution();
        // TO TEST
        System.out.println(solution.maxProfit(2,new int[]{3,2,6,5,0,3}));
        System.out.println(solution.maxProfit(2,new int[]{2,4,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length<2){
            return 0;
        }
        int[][] dp = new int[prices.length][2*k+1];
        dp[0][0] = 0;//第0次卖出
        for (int i = 0; i <k ; i++) {
            dp[0][2*i+1] = -prices[0];//第n次买入状态
            dp[0][2*i+2] = 0;//第n次卖出状态
        }
        for (int i = 1; i <prices.length ; i++) {
            for (int j = 0; j <k ; j++) {
                dp[i][2*j+1] = Math.max(dp[i-1][2*j+1],dp[i-1][2*j] - prices[i]);//第n次买入
                dp[i][2*j+2] = Math.max(dp[i-1][2*j+2],dp[i-1][2*j+1] + prices[i]);//第n次卖出
            }
        }
        return dp[prices.length - 1][2*k];

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