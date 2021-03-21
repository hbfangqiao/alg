//你的赛车起始停留在位置 0，速度为 +1，正行驶在一个无限长的数轴上。（车也可以向负数方向行驶。） 
//
// 你的车会根据一系列由 A（加速）和 R（倒车）组成的指令进行自动驾驶 。 
//
// 当车得到指令 "A" 时, 将会做出以下操作： position += speed, speed *= 2。 
//
// 当车得到指令 "R" 时, 将会做出以下操作：如果当前速度是正数，则将车速调整为 speed = -1 ；否则将车速调整为 speed = 1。 (当前所
//处位置不变。) 
//
// 例如，当得到一系列指令 "AAR" 后, 你的车将会走过位置 0->1->3->3，并且速度变化为 1->2->4->-1。 
//
// 现在给定一个目标位置，请给出能够到达目标位置的最短指令列表的长度。 
//
// 示例 1:
//输入: 
//target = 3
//输出: 2
//解释: 
//最短指令列表为 "AA"
//位置变化为 0->1->3
// 
//
// 示例 2:
//输入: 
//target = 6
//输出: 5
//解释: 
//最短指令列表为 "AAARA"
//位置变化为 0->1->3->7->7->6
// 
//
// 说明: 
//
// 
// 1 <= target（目标位置） <= 10000。 
// 
// Related Topics 堆 动态规划 
// 👍 90 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：赛车
public class P818RaceCar{
    public static void main(String[] args) {
        Solution solution = new P818RaceCar().new Solution();
        // TO TEST
        System.out.println(solution.racecar(3));
        System.out.println(solution.racecar(6));
        System.out.println(solution.racecar(6));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int racecar(int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i = 0; i <= target ; i++) {
            /**
             * 解释: 1<< forward - 1  为 2^n - 1
             * < 2*i 是 小车无论是前进或者倒退  back_point ----a---> target ----b---> extra_point  a 和 b 的距离都不能超过 target的值。否则，就白跑了。
             * 这个循环是 一路 执行指令A 狂奔
             */
            for (int forward = 1; (1 << forward) -1 < 2 * i; forward++) {
                int forwardDistance = (1 << forward) - 1;
                if (forwardDistance == i){
                    dp[i] = forward;
                }else if (forwardDistance > i) { //越过了目标点
                    dp[i] = Math.min(dp[i],forward + 1 + dp[forwardDistance - i]);
                }else { //没有越过目标点
                    for (int backward = 0; backward < forward ; backward++) {
                        int backwardDistance = (1 << backward) - 1;
                        dp[i] = Math.min(dp[i],forward + 1 + backward + 1 + dp[i - forwardDistance + backwardDistance]);
                    }
                }
            }
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √ 没有思路
2. 没有思路则直接看解法，比较解法优劣
https://leetcode-cn.com/problems/race-car/solution/dong-tai-gui-hua-jie-jue-sai-che-wen-ti-0qz3m/
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