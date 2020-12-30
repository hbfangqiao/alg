//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 789 👎 0


package leetcode.editor.cn;
//Java：跳跃游戏 II
public class P45JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        // TO TEST
        System.out.println(solution.jump(new int[]{2,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int current = 0;
        while (current < nums.length-1){
            step ++;
            int canStep = nums[current];
            if (current + canStep >= nums.length - 1){
                break;
            }
            int currentMaxStep = 0;
            int bestStep = 0;
            for (int i = current+1; i <=current+canStep && i < nums.length ; i++) {
                int nextCanStep = nums[i];
                int nextStep = (i - current) + nextCanStep;
                if (nextStep > currentMaxStep){
                    bestStep = i;
                    currentMaxStep = nextStep;
                }
            }
            current = bestStep;
        }
        return step;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
我的思路：[2,3,1,1,4]  当站在2时，遍历 3,1 看看 走3（3+1） 和 走1（1+2） 哪一步走的更远。选择更远的前进。
因为走3下一步能走的点可以覆盖掉所有走1时的点
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