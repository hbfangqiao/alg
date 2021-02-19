//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划 
// 👍 500 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：比特位计数
public class P338CountingBits{
    public static void main(String[] args) {
        Solution solution = new P338CountingBits().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.countBits(0)));
        System.out.println(Arrays.toString(solution.countBits(1)));
        System.out.println(Arrays.toString(solution.countBits(2)));
        System.out.println(Arrays.toString(solution.countBits(3)));
        System.out.println(Arrays.toString(solution.countBits(4)));
        System.out.println(Arrays.toString(solution.countBits(5)));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        for (int i = 1; i <=num ; i++) {
            if ((i & 1) == 0){
                dp[i] = dp[i >> 1];
            }else {
                dp[i] = dp[i-1]+1;
            }
        }
        return dp;
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

解法一：遍历每个数，依次求hammingWeight 时间复杂度O(nk) k为 n的二进制长度
public int[] countBits(int num) {
    int[] result = new int[num+1];
    for (int i = 0; i <=num ; i++) {
        result[i] = hammingWeight(i);
    }
    return result;
}

private int hammingWeight(int n){
    int count = 0;
    while (n!=0){
        n = n & (n - 1);
        count ++;
    }
    return count;
}

解法二: dp 时间复杂度O(n)
https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
*/
}