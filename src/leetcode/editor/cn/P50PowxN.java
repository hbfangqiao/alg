//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找 
// 👍 562 👎 0


package leetcode.editor.cn;

//Java：Pow(x, n)
public class P50PowxN {
    public static void main(String[] args) {
        Solution solution = new P50PowxN().new Solution();
        // TO TEST
        double v = solution.myPow(2, 3);
        System.out.println(v);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n < 0){
                return 1 / pow(x,-n);
            }
            return pow(x,n);
        }

        private double pow(double x,long n){
            if (n == 0){
                return 1;
            }
            double subResult = pow(x,n/2);
            return n%2 == 0 ? subResult * subResult : x * subResult * subResult;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
思路1：使用 2^3 == 2 * 2 * 2，
结果： 输入 0.00001 的 2147483647 次方 栈溢出
思路2：使用 x^n = x ^ (n/2) * n ^ (n/2)
结果：输入 0.00001 的 2147483647 次方 运行超时

2. 没有思路则直接看解法
https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
题解就是 我的思路2。
我的问题是 将 讲 2^8 -> 2^4 * 2^4 时 进行了两次运算。题解只进行了一次运算

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

我的解法一：栈溢出  输入x = 0.00001 的n = 2147483647 次方 栈溢出
public double myPow(double x, int n) {
    if (n == 0) {
        return 1;
    }
    if (n > 0) {
        return x * myPow(x, n - 1);
    }
    return (1 / x) * myPow(x, n + 1);

}

我的解法二：超时  输入 x = 0.00001 的n = 2147483647 次方 超时
public double myPow(double x, int n) {
    if (n < 0){
        return 1 / pow(x,-n);
    }
    return pow(x,n);
}

private double pow(double x,int n){
    if (n == 0){
        return 1;
    }
    int nextN;
    if (n % 2 == 0){
        nextN = n/2;
        return pow(x,nextN) * pow(x,nextN);
    }
    nextN = (int) ((n-1)/2);
    return x * pow(x, nextN) * pow(x, nextN);
}
*/
}