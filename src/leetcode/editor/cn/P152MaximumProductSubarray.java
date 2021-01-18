//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 906 👎 0


package leetcode.editor.cn;
//Java：乘积最大子数组
public class P152MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        // TO TEST
        int[] input = {2,3,-2,4};
        int[] input2 = {-1,0,-2};
        System.out.println(solution.maxProduct(input2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];
        dp_max[0] = nums[0];
        dp_min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            int min = nums[i] < 0 ? dp_max[i-1] : dp_min[i-1];
            int max = nums[i] < 0 ? dp_min[i-1] : dp_max[i-1];
            dp_max[i] = Math.max(nums[i]*max,nums[i]);
            dp_min[i] = Math.min(nums[i]*min,nums[i]);
            res = Math.max(res,dp_max[i]);
        }
        return res;
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