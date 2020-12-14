//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1872 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：接雨水
public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height));
        height = new int[]{4,2,0,3,2,5};
        System.out.println(solution.trap(height));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 1){
            return 0;
        }
        int result = 0;
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i <height.length ; i++) {
            if (!stack.isEmpty() && stack.peek().getLeftMaxVal() <= height[i]){
                while (!stack.isEmpty()){
                    Node node = stack.pop();
                    Integer capacity = node.getLeftMaxVal() - node.getVal();
                    result += capacity;
                }
            }
            if (stack.isEmpty()){
                stack.push(new Node(height[i],height[i]));
            }else {
                stack.push(new Node(height[i],Math.max(height[i],stack.peek().getLeftMaxVal())));
            }
        }
        int rightMax = 0;
        while (!stack.isEmpty()){
            Node node = stack.pop();
            Integer capacity = Math.min(node.getLeftMaxVal(),rightMax) - node.getVal();
            result += capacity > 0 ? capacity : 0;
            rightMax = Math.max(rightMax,node.getVal());
        }
        return result;
    }

    public class Node{
        private Integer val;
        private Integer leftMaxVal;

        public Node(Integer val, Integer leftMaxVal) {
            this.val = val;
            this.leftMaxVal = leftMaxVal;
        }

        public Integer getVal() {
            return val;
        }

        public Integer getLeftMaxVal() {
            return leftMaxVal;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
我的思路：因为涉及到左右相关，想到使用栈来解决。
栈中维护栈中存储左侧的最大值，当右侧出现比当前最大值还大的值时，弹出栈计算当前柱状所能存的水
结果
解答成功: 执行耗时:5 ms,击败了17.17% 的Java用户 内存消耗:38 MB,击败了82.74% 的Java用户

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