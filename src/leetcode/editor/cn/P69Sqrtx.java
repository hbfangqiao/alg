//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 566 👎 0


package leetcode.editor.cn;

//Java：x 的平方根
public class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
        // TO TEST
        System.out.println(solution.mySqrt(2147395599));
        int s = 2 + (3 - 2) / 2;
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int a) {
            long x = a;//初始迭代点
            while (x * x > a) {
                x = (x + a/x)/2;
            }
            return (int) x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
二分查找的前提条件：
1.单调性（递增或者递减）
2.有界性（有最大最小值）
3.可下标访问

第一遍：
1. 5-15分钟读题思考题目 √
2. 没有思路则直接看解法，比较解法优劣
a.二分查找
针对边界条件自己不好确定的，可以选择 一个 中间值验证 比如 实践答案 是 2.236 可以 left=2 right=3 进行验证
b.牛顿迭代法
参考资料：
解释牛顿迭代法是什么：https://www.zhihu.com/question/20690553
牛顿迭代法由x 推导 x+1 https://blog.csdn.net/batuwuhanpei/article/details/51979831
题解参考：https://blog.csdn.net/batuwuhanpei/article/details/51979831
思考：牛顿迭代法本来只能无限趋近于目标值，理论上会无限循环下去。为什么计算机可以在有限次数求得答案?
因为计算机有精度丢失，高位小数会被截断 。实际求得的值会更小

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

解法一：二分查找
public int mySqrt(int x) {
    if (x == 0 || x == 1) {
        return x;
    }
    int left = 1;
    int right = x;
    while (left <= right){
        int mid = left+(right - left)/2  ;
        if ((long)mid * mid > x){
            right = mid - 1;
        }else {
            left = mid + 1;
        }
    }
    return right;
}
*/
}