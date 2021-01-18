//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 674 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三角形最小路径和
public class P120Triangle{
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
        // TO TEST
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        System.out.println(solution.minimumTotal(list));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >= 0 ; i--) {
            for (int j = 0; j <triangle.get(i).size() ; j++) {
                A[j] = Math.min(A[j],A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
无DP思路
2. 没有思路则直接看解法，比较解法优劣 √
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