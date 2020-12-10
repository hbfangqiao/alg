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
//Java：柱状图中最大的矩形
public class P84LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
        // TO TEST
        int[] heights = new int[]{2,1,5,6,2,3};
        int largest = solution.largestRectangleArea(heights);
        System.out.println(largest);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
思路：暴力求解。遍历每个纵坐标，找到可以画矩形的开始值，结束值。时间复杂度O(n^2)
解答成功:
执行耗时:1109 ms,击败了6.96% 的Java用户
内存消耗:40.3 MB,击败了23.96% 的Java用户

2. 比较解法优劣
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