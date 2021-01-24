//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 450 👎 0


package leetcode.editor.cn;

//Java：打家劫舍 II
public class P213HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new P213HouseRobberIi().new Solution();
        // TO TEST
        int rob = solution.rob(new int[]{ 2, 3, 2});
        System.out.println(rob);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int[] dp = new int[nums.length + 1];
            dp[0] = 0;
            dp[1] = 0;
            int roberHeadResult = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                dp[i+2] = Math.max(dp[i] + nums[i],dp[i+1]);
                roberHeadResult = Math.max(roberHeadResult,dp[i+2]);
            }
            int roberTailResult = 0;
            for (int i = 0; i <nums.length - 1 ; i++) {
                dp[i+2] = Math.max(dp[i] + nums[i+1],dp[i+1]);
                roberTailResult = Math.max(roberTailResult,dp[i+2]);
            }
            return Math.max(roberHeadResult,roberTailResult);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √ 无dp思路,在一个环的情况下，不知道起点在哪里
2. 没有思路则直接看解法，比较解法优劣
思路：将环的问题拆分成两个单链的子问题，头和尾不能同时偷，要么偷头，要么偷尾。
3. 背诵和默写解法
看了思路后，写出答案。
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