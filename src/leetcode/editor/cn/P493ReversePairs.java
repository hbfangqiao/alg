//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 261 👎 0


package leetcode.editor.cn;
//Java：翻转对
public class P493ReversePairs{
    public static void main(String[] args) {
        Solution solution = new P493ReversePairs().new Solution();
        // TO TEST
        int[] input = {1,3,2,3,1};
        System.out.println(solution.reversePairs(input));
        System.out.println(solution.reversePairs(new int[]{2,4,3,5,1}));
        System.out.println(solution.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        return mergeSort(nums,0,nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right){
        if (left >= right) return 0;
        int mid = left + ((right - left) >> 1);
        int count = mergeSort(nums,left,mid) + mergeSort(nums,mid+1,right);
        int[] cache = new int[right - left + 1];
        int i = left,t = left, c = 0;
        for (int j = mid + 1; j <= right ; j++,c++) {
            while (i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
            while (t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cache[c] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid) cache[c++] = nums[t++];
        System.arraycopy(cache,0,nums,left,right - left + 1);
        return count;
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