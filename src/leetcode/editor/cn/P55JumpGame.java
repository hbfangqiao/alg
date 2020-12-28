//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组 
// 👍 980 👎 0


package leetcode.editor.cn;
//Java：跳跃游戏
public class P55JumpGame{
    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
        // TO TEST
        System.out.println(solution.canJump(new int[]{2,3,1,1,4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null){
            return false;
        }
        int canReach = nums.length - 1;
        for (int i = nums.length - 1; i >=0; i--) {
            if (nums[i] >= canReach - i){
                canReach = i;
            }
        }
        return canReach == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
难点还是如何想到贪心算法

2. 没有思路则直接看解法，比较解法优劣
a.贪心算法 时间复杂度O(n)
从后往前进行循环遍历。只要前面一个的步数能到达当前点，就将可到达的地方更新为前面一个点.

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