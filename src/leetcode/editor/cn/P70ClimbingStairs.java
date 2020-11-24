//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1262 👎 0


package leetcode.editor.cn;
//Java：爬楼梯
public class P70ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        // TO TEST
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int result = f1 + f2;
        for (int i = 3; i <=n ; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
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

懵逼的时候怎么做：
1.暴力求解
2. 找最基本的情况  --> 目的是找最近“重复子问题”。（因为计算机只会做重复的事）

当n = 0时
f(0) = 0; 没有楼梯所以没有走法
当n = 1时
f(1) = 1; 只能走1步上去
当n = 2时
f(2) = 2; 只能有2种情况，从地面f(0) 上2步，或者从第一级楼梯f(1) 上1步。
Q: 是不是还有从地面 上1步再上1步的情况？
A：这个情况会先到达f(1),相当于是从f(1) 再上一步到达f(2)，已经包含在f(1)的情况中了

推导公式
f(n) = f(n-1) + f(n-2)

我的代码：
public int climbStairs(int n) {
    int[] array = new int[n+1];
    array[0] = 1;
    array[1] = 1;
    if (n>=2){
        for (int i = 2; i <=n ; i++) {
            array[i] = array[i-1] + array[i-2];
        }
    }
    return array[n];
}



*/

}