//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法 
// 👍 119 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

//Java：模拟行走机器人
public class P874WalkingRobotSimulation{
    public static void main(String[] args) {
        Solution solution = new P874WalkingRobotSimulation().new Solution();
        // TO TEST
        int i = solution.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{new int[]{2, 4}});
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        int x = 0;int y=0;int di = 0;
        Set<String> obstacleSet = Arrays.stream(obstacles).map(e -> e[0] +","+ e[1]).collect(Collectors.toSet());
        int result = 0;
        for (int i = 0; i <commands.length ; i++) {
            int c = commands[i];
            if (c == -2){
                di = (di -1 + 4)%4;
                continue;
            }
            if (c == -1){
                di = (di + 1) % 4;
                continue;
            }
            for (int j = 0; j <c ; j++) {
                int xn = x + dx[di];
                int yn = y + dy[di];
                if (!obstacleSet.contains(xn+","+yn)){
                    x = xn;
                    y = yn;
                    result = Math.max(result,x*x + y*y);
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
自己思考主要是不同的方向会写很多if else

2. 没有思路则直接看解法，比较解法优劣
和P641双端队列 一样，再一次用到了 下标在一个数组中循环跑动

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