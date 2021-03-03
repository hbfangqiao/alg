//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1363 👎 0


package leetcode.editor.cn;

//Java：最长递增子序列
public class P300LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new P300LongestIncreasingSubsequence().new Solution();
        // TO TEST
//        System.out.println(solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));// 1 1 1 2 2 3 4 4
//        System.out.println(solution.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
//        System.out.println(solution.lengthOfLIS(new int[]{7}));
//        System.out.println(solution.lengthOfLIS(new int[]{}));
////        //1 2 1 3 3 4
//        System.out.println(solution.lengthOfLIS(new int[]{0,1,0,3,2,3}));
//        System.out.println(solution.lengthOfLIS(new int[]{4,10,4,3,8,9}));
//        System.out.println(solution.lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12}));//6

        System.out.println(solution.getNumPosInRange(3,new int[]{0,1,3,5,7,9},4));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length,len = 1;
        if (nums == null || n == 0) {
            return 0;
        }
        int d[] = new int[n + 1];
        d[len] = nums[0];
        for (int i = 0; i <n ; ++i) {
            if (nums[i] > d[len]){
                d[++len] = nums[i];
                continue;
            }
            int pos = getNumPosInRange(len, d, nums[i]);
            d[pos+1] = nums[i];
        }
        return len;
    }
        // 找到第一个比 num 小的数的位置
        private int getNumPosInRange(int len, int[] d, int num) {
            int l = 1, r = len,pos = 0;
            while (l <= r){
                int mid = (l + r) >> 1;
                if (d[mid] < num){
                    pos = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return pos;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
我的思路:
dp[i] 代表子序列num[0...i]  且以num[i]为最后一位 的子序列最大值
2. 没有思路则直接看解法，比较解法优劣
dp[i] 代表子序列num[0...i] 且以num[i]为最后一位 的最长子序列长度。 dp方程 dp[i] = max(loop(dp[0] -> dp[i-1]))
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

我的思路：	dp[i] 代表子序列num[0...i]  且以num[i]为最后一位 的子序列最大值
时间复杂度O(n)
public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    if (nums.length == 1) {
        return 1;
    }
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int max = 1;
    for (int i = 1; i <nums.length ; i++) {
        if (nums[i] == nums[i-1]) {
            dp[i] = dp[i-1];
        }
        int maxValue = -1;
        for (int j = i-1; j >= 0 ; j--) {
            if (nums[j] < nums[i]){
                maxValue = Math.max(dp[j],maxValue);
            }
        }
        dp[i] = maxValue == -1 ? 1 : maxValue + 1;
        max = Math.max(dp[i],max);
    }
    return max;
}

参考 dp题解 O（n2）
https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[j]+1,dp[i]);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
*/
}