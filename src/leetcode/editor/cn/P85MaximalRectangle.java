//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 836 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：最大矩形
public class P85MaximalRectangle{
    public static void main(String[] args) {
        Solution solution = new P85MaximalRectangle().new Solution();
        // TO TEST
        /**
         * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
         */
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        char[][] m2 = {};
//        System.out.println(solution.maximalRectangle(matrix));
        System.out.println(solution.maximalRectangle(m2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        int max = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (matrix[i][j] == '1'){
                    heights[j] += 1;
                }else {
                    heights[j] = 0;
                }
            }
            max = Math.max(max,largestRectangleArea(heights));
        }
        return max;
    }

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