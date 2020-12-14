//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 657 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//Java：滑动窗口最大值
public class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = solution.maxSlidingWindow(nums, 1);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] results = new int[nums.length - k + 1];
            int n = 0;
            Deque<Integer> deque = new ArrayDeque<>();//存下标
            for (int i = 0; i < nums.length; i++) {
                if (!deque.isEmpty() && deque.peekFirst() == i - k){//最大值已经到了需要被移除的时候
                    deque.removeFirst();
                }
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                    //将队列中小于当前值的数都移除掉，因为这些值比当前值先出去，又比当前值小，估一定不会成为最大值
                    deque.removeLast();
                }
                deque.addLast(i);
                if (i >= k-1) {//已经初始化完窗口了，需要填值
                    results[n++] = nums[deque.peekFirst()];
                }
            }
            return results;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
思路：遍历的时候 使用一个 FIFO 队列来存储其中的 K个值。记录其中的最大值，以及最大值的个数。
当队列中有K个值的时候，将当前的最大值放入结果。当窗口开始滑动时，更新记录的最大值和个数。并将最大值放入结果集中。
-- 思路解答失败，当弹出所有最大值时无法在常数时间内确定当前最大值

2. 没有思路则直接看解法，比较解法优劣 √
思路：双端队列保证最值
讲解：https://leetcode-cn.com/problems/sliding-window-maximum/solution/3chong-jie-jue-fang-shi-by-sdwwld/

3. 背诵和默写解法 √
官方的写法太晦涩。 主要是自己理解了，在写出来。

第二遍
1. 马上自己写 -> LeeCode提交
2. 多种解法比较，体会 -> 优化
第三遍
1. 过了一天后重复练习相同题目
第四遍
1. 过了一周重复练习
第五遍
1. 面试前一周重复练习

我的双端队列解法：
public int[] maxSlidingWindow(int[] nums, int k) {
    int[] results = new int[nums.length - k + 1];
    int n = 0;
    Deque<Integer> deque = new ArrayDeque<>();//存下标
    for (int i = 0; i < nums.length; i++) {
        if (!deque.isEmpty() && deque.peekFirst() == i - k){//最大值已经到了需要被移除的时候
            deque.removeFirst();
        }
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
            //将队列中小于当前值的数都移除掉，因为这些值比当前值先出去，又比当前值小，估一定不会成为最大值
            deque.removeLast();
        }
        deque.addLast(i);
        if (i >= k-1) {//已经初始化完窗口了，需要填值
            results[n++] = nums[deque.peekFirst()];
        }
    }
    return results;
}
*/
}