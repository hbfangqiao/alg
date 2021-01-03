//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：matrix = [], target = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 0 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 294 👎 0


package leetcode.editor.cn;

//Java：搜索二维矩阵
public class P74SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new P74SearchA2dMatrix().new Solution();
        // TO TEST
        int[][] matrix = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50},
        };
        System.out.println(solution.searchMatrix(matrix, 24));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int left = 0, right = matrix.length * matrix[0].length - 1;
            while (left <= right) {
                int mid = left + (right - left)/2;
                int midNum = getNum(mid,matrix);
                if (midNum == target){
                    return true;
                }
                if (midNum > target){
                    right = mid - 1;
                }
                if (midNum < target){
                    left = mid + 1;
                }
            }
            return false;
        }

        private int getNum(int l, int[][] matrix) {
            int m = l / matrix[0].length;
            int n = l % matrix[0].length;
            return matrix[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
思路：将二维矩阵展开成一维数组，执行二分查找。
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