//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。 
//
// 请找出其中最小的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数都是 唯一 的 
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转 
// 
// Related Topics 数组 二分查找 
// 👍 320 👎 0


package leetcode.editor.cn;
//Java：寻找旋转排序数组中的最小值
public class P153FindMinimumInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new P153FindMinimumInRotatedSortedArray().new Solution();
        // TO TEST
//        int[] nums = new int[]{11,13,15,17};
        int[] nums = new int[]{4,5,6,7,11,-7,0,1,2};
        System.out.println(solution.findMin(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int left = 0,right = nums.length - 1,mid;
        int min = nums[0];//避免没有出现旋转的情况
        while (left <= right){
            mid = left + (right - left)/2;
            min = Math.min(min,nums[mid]);
            if (nums[mid] >= nums[0]){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
我的思路：
有旋转的前提下（第一次解答失败，因为没有考虑没有旋转的情况下的逻辑）
如果 nums[mid] > muns[0] 那么 最小值一定在右边
否则 最小值一定在左边
考虑到可能没有旋转，所以把num[0] 设定为最初的最小值
执行耗时: 0 ms,击败了100% 的Java用户 内存消耗:37.9 MB,击败了59% 的Java用户


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