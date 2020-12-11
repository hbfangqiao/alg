//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1054 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：柱状图中最大的矩形
public class P84LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
        // TO TEST
//        int[] heights = new int[]{2,1,5,6,2,3};
//        int[] heights = new int[]{5,4,1,2};
//        int[] heights = new int[]{0,0,0,0,0,0,0,0,2147483647};
        int[] heights = new int[]{2,2,2,1};
        int largest = solution.largestRectangleArea(heights);
        System.out.println(largest);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack();

        int len = heights.length;
        int maxArea = Integer.MIN_VALUE;

        for (int i=0;i<len;i++) {

            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int partialMaxArea = heights[stack.pop()] * (i - (stack.isEmpty()?0:stack.peek()+1));
                maxArea = Math.max(maxArea, partialMaxArea);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            int partialMaxArea = heights[stack.pop()] * (len - (stack.isEmpty()?0:stack.peek()+1));
            maxArea = Math.max(maxArea, partialMaxArea);
        }

        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
思路：暴力求解。遍历每个纵坐标，找到可以画矩形的开始值，结束值。时间复杂度O(n^2)
解答成功:
执行耗时:1109 ms,击败了6.96% 的Java用户
内存消耗:40.3 MB,击败了23.96% 的Java用户

2. 比较解法优劣  √
单调栈法 时间复杂度 O(n)

我的单调栈题解 VS 大佬的单调栈题解
a.我思考的时候，针对于 高度相等的情况，进行了特殊处理，只处理最右边的一个值。 否则过程中会运算出错误的面积
b.大佬的题解中没有进行特除处理 针对于 {2,2,1}这种情况 允许 (1,2) 运算出错误的结果2，但是在算 (0,2)的时候，
会运算出正确的结果4

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

我的题解：
public int largestRectangleArea(int[] heights) {
    int largest = 0;
    for (int i = 0; i <heights.length ; i++) {
        int startX = 0;//默认开始值为0
        int endX = i;
        int height = heights[i];
        for (int j = 0; j<= i;j++){
            if (heights[j] < height ){
                startX = j+1;//找到离本身最近，又比自己height低的x坐标，+1是因为这个x不参与画矩形
            }
        }
        for (int j = i; j <= heights.length -1 ; j++) {
            if (heights[j] < height){
                break;
            }
            endX = j;
        }
        largest = Math.max(largest,(endX+1 - startX)*height);
    }
    return largest;
}

我的单调栈法题解：题交错误了两次，第一次是 宽度运算没有使用 left 进行运算。 第二次是 值相同时没有将x 进行更新取最近的一个
    public int largestRectangleArea(int[] heights) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(-1,-1));
        Integer maxArea = 0;
        for (int i = 0; i <heights.length ; i++) {
            if (heights[i] > stack.peek().val){
                stack.push(new Node(heights[i],i));
            }
            if (heights[i] == stack.peek().val){
                stack.peek().x = i;
            }
            if (heights[i] < stack.peek().val){
                while (stack.peek().val > heights[i]){
                    Node node = stack.pop();
                    Node leftNode = stack.peek();
                    maxArea = Math.max(maxArea, (i - leftNode.x -1) * node.val);
                }
                stack.push(new Node(heights[i],i));
            }
        }
        while (stack.peek().x != -1){
            Node node = stack.pop();
            Node leftNode = stack.peek();
            maxArea = Math.max(maxArea,(heights.length - 1 - leftNode.x) * node.val);
        }
        return maxArea;
    }

    class Node{
        private Integer val;
        private Integer x;

        public Node(Integer val, Integer x) {
            this.val = val;
            this.x = x;
        }

        public Integer getVal() {
            return val;
        }

        public Integer getX() {
            return x;
        }
    }

解法一：
public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0){
        return 0;
    }
    Stack<Integer> stack = new Stack();

    int len = heights.length;
    int maxArea = Integer.MIN_VALUE;

    for (int i=0;i<len;i++) {

        while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
            int partialMaxArea = heights[stack.pop()] * (i - (stack.isEmpty()?0:stack.peek()+1));
            maxArea = Math.max(maxArea, partialMaxArea);
        }

        stack.push(i);
    }

    while (!stack.isEmpty()){
        int partialMaxArea = heights[stack.pop()] * (len - (stack.isEmpty()?0:stack.peek()+1));
        maxArea = Math.max(maxArea, partialMaxArea);
    }

    return maxArea;
}

*/
}